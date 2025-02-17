/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.core.draw.j2se.engine;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.draw.j2se.ctx.CoreDrawJ2seCtx;
import pasa.cbentley.framework.coredraw.src4.engine.FontAbstract;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechFont;

public abstract class FontJ2se extends FontAbstract {

   protected String fontNameInit;

   protected int    points;

   protected int    fontWidth = 0;

   public FontJ2se(CoreDrawJ2seCtx cdc) {
      super(cdc);
   }

   /**
    * Create a font object
    * @param cdc
    * @param face uses the default font for this face type
    * @param style
    * @param size
    */
   public FontJ2se(CoreDrawJ2seCtx cdc, int face, int style, int size) {
      super(cdc);
      this.face = face;
      this.style = style;
      this.size = size;

      //get the font from the customizer or by the default config
      FontCustomizerJ2se fontCustomizer = cdc.getFontCustomizerJ2SE();

      if (face == FACE_01_MONOSPACE) {
         fontNameInit = fontCustomizer.getDefaultFontNameMono();
      } else if (face == FACE_02_PROPORTIONAL) {
         fontNameInit = fontCustomizer.getDefaultFontNameProportional();
      } else {
         String def = fontCustomizer.getDefaultFontNameSystem();
         //custom font point that was set
         fontNameInit = cdc.getFontFactory().getFontFaceFromID(face, def);
      }

      points = cdc.getFontFactory().getFontPoint(size);
      points += cdc.getFontFactory().getFontPointExtraShift();
   }

   public boolean isMonospace() {
      if (face == ITechFont.FACE_01_MONOSPACE) {
         return true;
      }
      return stringWidth("m") == stringWidth("i");
   }

   public abstract int getAscent();

   public abstract int getDescent();

   public int getWidthWeigh() {
      if (fontWidth != 0) {
         fontWidth = stringWidth("m");
      }
      return fontWidth;
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, FontJ2se.class, 74);
      toStringPrivate(dc);
      super.toString(dc.sup());

      dc.appendVarWithNewLine("getHeight", getHeight());
      dc.appendVarWithSpace("getWidthWeigh", getWidthWeigh());
      dc.appendVarWithSpace("fontWidth", fontWidth);

      dc.nl();
      dc.append("Width of chars : ");
      dc.appendVarWithSpace("m", charWidth('m'));
      dc.appendVarWithSpace("i", charWidth('i'));
      dc.appendVarWithSpace("_", charWidth('_'));
      dc.appendVarWithSpace("|", charWidth('|'));

      dc.nl();
      dc.append("Width of strings : ");
      dc.appendVarWithSpace("mi|", stringWidth("mi|"));
      dc.appendVarWithSpace("str_i", stringWidth("str_i"));
   }

   private void toStringPrivate(Dctx dc) {
      dc.appendVarWithSpace("fontNameInit", fontNameInit);
      dc.appendVarWithSpace("points", points);
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, FontJ2se.class,101);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
