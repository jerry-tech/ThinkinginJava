package chapter7Polymorphism;

/**
 * Exercise 15:    (2) Add a RectangularGlyph to PolyConstructors.java and demonstrate the problem described in
 *      this section.
 *
 *      @see Glyph
 *      @see PolyConstructors
 *      @see RoundGlyph
 *      @see Question7
 */
public class RectangularGlyph extends Glyph{
    private int width = 2;
    private int length = 3;

    public RectangularGlyph(int width, int length) {
        this.width = width;
        this.length = length;
        System.out.println("RectangleGlyph.draw(), width = " + this.width);
        System.out.println("RectangleGlyph.draw(), length = " + this.length);
    }

    public void draw() {
        System.out.println("RectangleGlyph.draw(), width = " + width);
        System.out.println("RectangleGlyph.draw(), length = " + length);
    }
}
