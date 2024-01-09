/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.j2se.ctx;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.coredraw.src4.ctx.ConfigCoreDrawDef;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechFont;

/**
 * Default configuration settings for J2SE framework hosts.
 * 
 * If you want custom configuration, in your launcher, create a new class
 * @author Charles Bentley
 *
 */
public class ConfigCoreDrawJ2seDef extends ConfigCoreDrawDef implements IConfigCoreDrawJ2se, ITechFont {

   protected int[] fontPoints;

   public ConfigCoreDrawJ2seDef(UCtx uc) {
      super(uc);

      fontPoints = new int[ITechFont.SIZE_X_NUM];
      fontPoints[ITechFont.SIZE_1_TINY] = 8;
      fontPoints[ITechFont.SIZE_2_SMALL] = 10;
      fontPoints[ITechFont.SIZE_3_MEDIUM] = 12;
      fontPoints[ITechFont.SIZE_4_LARGE] = 16;
      fontPoints[ITechFont.SIZE_5_HUGE] = 22;
   }

   public int[] getFontPoints() {
      return fontPoints;
   }

   public String getFontMonospace() {
      return "Courier New";
   }

   public String getFontSystem() {
      return "System";
   }

   public String getFontProportional() {
      return "Segoe UI";
   }
   
   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, ConfigCoreDrawJ2seDef.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
      
      dc.appendVarWithNewLine("getFontMonospace()", getFontMonospace());
      dc.appendVarWithNewLine("getFontSystem()", getFontSystem());
      dc.appendVarWithNewLine("getFontProportional()", getFontProportional());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, ConfigCoreDrawJ2seDef.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   

}
