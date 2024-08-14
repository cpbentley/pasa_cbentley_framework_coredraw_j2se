/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.core.draw.j2se.engine;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.draw.j2se.ctx.CoreDrawJ2seCtx;
import pasa.cbentley.framework.core.draw.j2se.ctx.IConfigCoreDrawJ2se;
import pasa.cbentley.framework.coredraw.src4.ctx.IConfigCoreDraw;
import pasa.cbentley.framework.coredraw.src4.ctx.ToStringStaticCoreDraw;
import pasa.cbentley.framework.coredraw.src4.engine.FontFactoryAbstract;
import pasa.cbentley.framework.coredraw.src4.engine.VisualState;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechFont;

public abstract class FontFactoryJ2se extends FontFactoryAbstract {
   /**
    * In some frameworks like J2ME and android, font points are not used
    */
   protected int[] fontPoints = null;

   public FontFactoryJ2se(CoreDrawJ2seCtx cdc) {
      super(cdc);

      IConfigCoreDrawJ2se config = cdc.getConfigCoreDrawJ2se();
      fontPoints = new int[ITechFont.SIZE_X_NUM];
      fontPoints[SIZE_0_DEFAULT] = config.getFontPoint_03_Medium();
      fontPoints[SIZE_1_TINY] = config.getFontPoint_01_Tiny();
      fontPoints[SIZE_2_SMALL] = config.getFontPoint_02_Small();
      fontPoints[SIZE_3_MEDIUM] = config.getFontPoint_03_Medium();
      fontPoints[SIZE_4_LARGE] = config.getFontPoint_04_Large();
      fontPoints[SIZE_5_HUGE] = config.getFontPoint_05_Huge();

      fontPointsExtraShift = cdc.getConfigCoreDrawJ2se().getFontPointsExtraShift();

   }

   /**
    * By Default we are not able to do this. this will depend on the host capabilities
    */
   public VisualState fontSizeDecrease() {
      VisualState vs = new VisualState();
      for (int i = 0; i < fontPoints.length; i++) {
         if (fontPoints[i] > 0)
            fontPoints[i]--;
      }
      //update all fonts
      vs.fontPoints = fontPoints;
      clearFontCache();
      return vs;
   }

   /**
    * Caller must call the hooks for updating current fonts in the GUI layout, i.e. it has to renew the
    * layout of all graphical components including cached.
    * <br>
    * 
    * @return
    */
   public VisualState fontSizeIncrease() {
      VisualState vs = new VisualState();
      for (int i = 0; i < fontPoints.length; i++) {
         fontPoints[i]++;
      }
      vs.fontPoints = fontPoints;
      clearFontCache();
      return vs;
   }

   public String[] getFontFamilies() {
      String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
      return fonts;
   }

   public String[] getFontNames() {
      Font[] allFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
      String fonts[] = new String[allFonts.length];
      for (int i = 0; i < fonts.length; i++) {
         fonts[i] = allFonts[i].getFamily() + " : " + allFonts[i].getFontName();
      }
      return fonts;
   }

   /**
    * 
    */
   public int getFontPoint(int size) {

      if (size < -1) {
         throw new IllegalArgumentException();
      } else if (size > ITechFont.SIZE_X_NUM) {
         //#debug
         toDLog().pFlow("host size parameter. taking host size at face value -> points=" + size, null, FontFactoryJ2se.class, "getFontPoint@60", LVL_03_FINEST, true);

         return size;
      } else {
         int points = fontPoints[size];

         //#debug
         toDLog().pFlow("for size=" + ToStringStaticCoreDraw.fontSize(size) + " points=" + points, null, FontFactoryJ2se.class, "getFontPoint@64", LVL_03_FINEST, true);

         return points;
      }
   }

   public int[] getFontPoints() {
      return fontPoints;
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, FontFactoryJ2se.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
      if (fontPoints == null) {
         dc.append("fontPoints array is null");
      } else {
         dc.appendVarWithNewLine("SIZE_0_DEFAULT", fontPoints[ITechFont.SIZE_0_DEFAULT]);
         dc.appendVarWithNewLine("SIZE_1_TINY", fontPoints[ITechFont.SIZE_1_TINY]);
         dc.appendVarWithNewLine("SIZE_2_SMALL", fontPoints[ITechFont.SIZE_2_SMALL]);
         dc.appendVarWithNewLine("SIZE_3_MEDIUM", fontPoints[ITechFont.SIZE_3_MEDIUM]);
         dc.appendVarWithNewLine("SIZE_4_LARGE", fontPoints[ITechFont.SIZE_4_LARGE]);
         dc.appendVarWithNewLine("SIZE_5_HUGE", fontPoints[ITechFont.SIZE_5_HUGE]);
      }
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, FontFactoryJ2se.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }

   //#enddebug

}
