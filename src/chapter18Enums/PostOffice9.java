package chapter18Enums;

//Exercise 9: (5) Modify class PostOffice so that it uses an EnumMap. Project:2
//        Specialized languages like Prolog use backward chaining in order to solve problems like this.
//        Using PostOffice.java for inspiration, research such languages and develop a program that
//        allows new "rules" to be easily added to the system.

import java.util.*;

class Mail1 {
    // The NO's lower the probability of random selection:
    enum GeneralDelivery { YES, NO1, NO2, NO3, NO4, NO5 }
    enum Scannability { UNSCANNABLE, YES1, YES2, YES3, YES4 }
    enum Readability { ILLEGIBLE, YES1, YES2, YES3, YES4 }
    enum Address { INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6 }
    enum ReturnAddress { MISSING, OK1, OK2, OK3, OK4, OK5 }
    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    static long counter = 0;
    long id = counter++;
    public String toString() { return "Mail " + id; }
    public String details() {
        return toString() +
                ", General Delivery: " + generalDelivery +
                ", Address Scannability: " + scannability +
                ", Address Readability: " + readability +
                ", Address Address: " + address +
                ", Return address: " + returnAddress;
    }
    // Generate test Mail:
    public static Mail1 randomMail() {
        Mail1 m = new Mail1();
        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scannability = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        return m;
    }
    public static Iterable<Mail1> generator(final int count) {
        return new Iterable<>() {
            int n = count;
            public Iterator<Mail1> iterator() {
                return new Iterator<>() {
                    public boolean hasNext() { return n-- > 0; }
                    public Mail1 next() { return randomMail(); }
                    public void remove() { // not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}

interface Handler { abstract boolean handle(Mail1 m); } // Command design pattern

public class PostOffice9 {
    enum MailHandler { GENERAL_DELIVERY, MACHINE_SCAN, VISUAL_INSPECTION, RETURN_TO_SENDER }
    public static void handle(Mail1 m, EnumMap<MailHandler,Handler> em) {
        for(Map.Entry<MailHandler,Handler> e : em.entrySet()) {
            if(e.getValue().handle(m)) return;
        }
        System.out.print(m + " is a dead letter");
    }
    public static void main(String[] args) {
        EnumMap<MailHandler,Handler> em = new EnumMap<>(MailHandler.class);
        em.put(MailHandler.GENERAL_DELIVERY, m -> {
            switch(m.generalDelivery) {
                case YES:
                    System.out.print("Using general delivery for " + m);
                    return true;
                default: return false;
            }
        });
        em.put(MailHandler.MACHINE_SCAN, m -> {
            switch(m.scannability) {
                case UNSCANNABLE: return false;
                default:
                    switch(m.address) {
                        case INCORRECT: return false;
                        default:
                            System.out.print("Delivering " + m + " automatically");
                            return true;
                    }
            }
        });
        em.put(MailHandler.VISUAL_INSPECTION, m -> {
            switch(m.readability) {
                case ILLEGIBLE: return false;
                default:
                    switch(m.address) {
                        case INCORRECT: return false;
                        default:
                            System.out.print("Delivering " + m + " normally");
                            return true;
                    }
            }
        });
        em.put(MailHandler.RETURN_TO_SENDER, m -> {
            switch(m.returnAddress) {
                case MISSING: return false;
                default:
                    System.out.print("Return " + m + " to sender");
                    return true;
            }
        });
        for(Mail1 mail : Mail1.generator(10)) {
            System.out.print(mail.details());
            handle(mail, em);
            System.out.print("*****");
        }
    }
}

