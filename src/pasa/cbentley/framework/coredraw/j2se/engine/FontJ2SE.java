/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.j2se.engine;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.coredraw.j2se.ctx.CoreDrawJ2seCtx;
import pasa.cbentley.framework.coredraw.src4.engine.FontAbstract;

public abstract class FontJ2SE extends FontAbstract {

   protected String                fontName;

   protected int                   points;

   protected int                   fontWidth = 0;

   protected final CoreDrawJ2seCtx drwj2sec;

   /**
    * Create a font object
    * @param cuic
    * @param face uses the default font for this face type
    * @param style
    * @param size
    */
   public FontJ2SE(CoreDrawJ2seCtx cuic, int face, int style, int size) {
      super(cuic);
      this.drwj2sec = cuic;
      this.face = face;
      this.style = style;
      this.size = size;

      if (face == FACE_MONOSPACE) {
         fontName = cuic.getDefaultFontNameMono();
      } else if (face == FACE_PROPORTIONAL) {
         fontName = cuic.getDefaultFontNameProportional();
      } else {
         fontName = cuic.getDefaultFontNameSystem();
      }

      points = cac.getFontFactory().getFontPoint(size);
      points += cac.getFontFactory().getFontPointExtraShift();
   }

   public int getWidthWeigh() {
      if (fontWidth != 0) {
         fontWidth = stringWidth("m");
      }
      return fontWidth;
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, FontJ2SE.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
      

      dc.appendVarWithNewLine("getHeight()", getHeight());
      dc.appendVarWithSpace("getWidthWeigh", getWidthWeigh());
      dc.appendVarWithSpace("fontWidth", fontWidth);

      dc.nl();
      dc.append("Width of chars : ");
      dc.appendVarWithSpace("space", charWidth(' '));
      dc.appendVarWithSpace("m", charWidth('m'));
      dc.appendVarWithSpace("i", charWidth('i'));
      dc.appendVarWithSpace("_", charWidth('_'));
      
      dc.nl();
      dc.append("Width of strings : ");
      dc.appendVarWithSpace("mi", stringWidth("mi"));
      dc.appendVarWithSpace("m i", stringWidth("m i"));
   }

   private void toStringPrivate(Dctx dc) {
      dc.appendVarWithSpace("fontName", fontName);
      dc.appendVarWithSpace("points", points);
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, FontJ2SE.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
