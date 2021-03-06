package chapter18Enums;

import java.util.*;

//Exercise 8: (6) Modify PostOffice.java so it has the ability to forward mail.

class Mail {
    // The NO's lower the probability of random selection:
    enum GeneralDelivery { YES, NO1, NO2, NO3, NO4, NO5 }
    enum Scannability { UNSCANNABLE, YES1, YES2, }
    enum Readability { ILLEGIBLE, YES1, YES2, YES3, YES4 }
    enum ForwardAddress { YES, NO1, NO2, NO3, NO4, NO5 }
    enum Address { INCORRECT, OK1, OK2, OK3, OK4, OK5 }
    enum ReturnAddress { MISSING, OK1, OK2, OK3, OK4, OK5 }
    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    ForwardAddress forwardAddress;
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
                ", ForwardAddress: " + forwardAddress +
                ", Address Address: " + address +
                ", Return address: " + returnAddress;
    }
    // Generate test Mail:
    public static Mail randomMail() {
        Mail m = new Mail();
        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scannability = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.forwardAddress = Enums.random(ForwardAddress.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        return m;
    }
    public static Iterable<Mail> generator(final int count) {
        return new Iterable<Mail>() {
            int n = count;
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    public boolean hasNext() { return n-- > 0; }
                    public Mail next() { return randomMail(); }
                    public void remove() { // not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}

public class PostOffice8 {
    enum MailHandler {
        GENERAL_DELIVERY {
            boolean handle(Mail m) {
                switch(m.generalDelivery) {
                    case YES:
                        System.out.print("Using general delivery for " + m);
                        return true;
                    default: return false;
                }
            }
        },
        MACHINE_SCAN {
            boolean handle(Mail m) {
                switch(m.scannability) {
                    case UNSCANNABLE: return false;
                    default:
                        switch(m.forwardAddress) {
                            case YES:
                                System.out.print("Forwarding " + m + " automatically");
                                return true;
                            default:
                                switch(m.address) {
                                    case INCORRECT: return false;
                                    default:
                                        System.out.print("Delivering " + m + " automatically");
                                        return true;
                                }
                        }


                }
            }
        },
        FORWARDING {
            boolean handle(Mail m) {
                switch(m.forwardAddress) {
                    case YES:
                        System.out.print("Forwarding " + m);
                        return true;
                    default: return false;

                }
            }
        },
        VISUAL_INSPECTION {
            boolean handle(Mail m) {
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
            }
        },
        RETURN_TO_SENDER {
            boolean handle(Mail m) {
                switch(m.returnAddress) {
                    case MISSING: return false;
                    default:
                        System.out.print("Return " + m + " to sender");
                        return true;
                }
            }
        };
        abstract boolean handle(Mail m);
    }
    static void handle(Mail m) {
        for(MailHandler handler : MailHandler.values())
            if(handler.handle(m)) return;
        System.out.print(m + " is a dead letter");
    }
    public static void main(String[] args) {
        for(Mail mail : Mail.generator(20)) {
            System.out.print(mail.details());
            handle(mail);
            System.out.print("*****");
        }
    }
}

