package chapter7Polymorphism;

/**
 * Exercise 15:    (2) Add a RectangularGlyph to PolyConstructors.java and demonstrate the problem described in
 *      this section.
 *
 *      @see Glyph
 *      @see Question7
 *      @see RoundGlyph
 *      @see RectangularGlyph
 */
public class PolyConstructors {
    RoundGlyph roundGlyph = new RoundGlyph(5);
    RectangularGlyph rectangularGlyph = new RectangularGlyph(6,7);
}
