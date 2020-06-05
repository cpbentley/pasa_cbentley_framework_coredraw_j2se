/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.j2se.ctx;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.byteobjects.src4.ctx.BOCtx;
import pasa.cbentley.byteobjects.src4.ctx.IConfigBO;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.framework.coredraw.src4.ctx.CoreDrawCtx;
import pasa.cbentley.framework.coredraw.src4.ctx.IConfigCoreDraw;

public abstract class CoreDrawJ2seCtx extends CoreDrawCtx {

   private String defaultFontNameMono;

   private String defaultFontNameProportional;

   private String defaultFontNameSystem;

   public CoreDrawJ2seCtx(IConfigCoreDraw configDraw, BOCtx boc) {
      super(configDraw, boc);
   }

   public String getDefaultFontNameMono() {
      if (defaultFontNameMono == null) {
         //use hardcoded default
         defaultFontNameMono = getDefaultFontNameMonoSub();
      }
      return defaultFontNameMono;
   }

   protected void matchConfig(IConfigBO config, ByteObject settings) {
      super.matchConfig(config, settings);
   }

   protected abstract String getDefaultFontNameMonoSub();

   /**
    * 
    * @return
    */
   public String getDefaultFontNameProportional() {
      if (defaultFontNameMono == null) {
         //use hardcoded default
         defaultFontNameMono = getDefaultFontNamePropSub();
      }
      return defaultFontNameProportional;
   }

   protected abstract String getDefaultFontNamePropSub();

   public String getDefaultFontNameSystem() {
      if (defaultFontNameMono == null) {
         //use hardcoded default
         defaultFontNameMono = getDefaultFontNameSystemSub();
      }
      return defaultFontNameSystem;
   }

   protected abstract String getDefaultFontNameSystemSub();

   public boolean hasFeatureSupport(int supportID) {
      //#debug
      toDLog().pFlow("supportID=" + supportID + " ", this, CoreDrawJ2seCtx.class, "hasFeatureSupport", LVL_05_FINE, true);

      switch (supportID) {
         case SUP_ID_06_CUSTOM_FONTS:
            return true;
         case SUP_ID_07_IMAGE_SCALING:
            return true;
         default:
            break;
      }
      return false;
   }

   public void setDefaultFontNameMono(String defaultFontNameMono) {
      //validates the font name for the system?
      this.defaultFontNameMono = defaultFontNameMono;
   }

   public void setDefaultFontNameProportional(String defaultFontNameProportional) {
      this.defaultFontNameProportional = defaultFontNameProportional;
   }

   public void setDefaultFontNameSystem(String defaultFontNameSystem) {
      this.defaultFontNameSystem = defaultFontNameSystem;
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, CoreDrawJ2seCtx.class);
      toStringPrivate(dc);
      super.toString(dc.sup());
      
      dc.appendVarWithSpace("defaultFontNameMono", defaultFontNameMono);
      dc.appendVarWithSpace("defaultFontNameProportional", defaultFontNameProportional);
      dc.appendVarWithSpace("defaultFontNameProportional", defaultFontNameProportional);
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, CoreDrawJ2seCtx.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
