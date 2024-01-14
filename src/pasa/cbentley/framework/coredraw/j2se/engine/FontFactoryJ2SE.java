/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.j2se.engine;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.coredraw.j2se.ctx.CoreDrawJ2seCtx;
import pasa.cbentley.framework.coredraw.src4.engine.FontFactoryAbstract;

public abstract class FontFactoryJ2SE extends FontFactoryAbstract {

   public FontFactoryJ2SE(CoreDrawJ2seCtx jcac) {
      super(jcac);

   }

   public String[] getFontNames() {
      Font[] allFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
      String fonts[] = new String[allFonts.length];
      for (int i = 0; i < fonts.length; i++) {
         fonts[i] = allFonts[i].getFamily() + " : "+ allFonts[i].getFontName();
      }
      return fonts;
   }


   public String[] getFontFamilies() {
      String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
      return fonts;
   }

   public int[] getFontPoints() {
      return fontPoints;
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, FontFactoryJ2SE.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, FontFactoryJ2SE.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
