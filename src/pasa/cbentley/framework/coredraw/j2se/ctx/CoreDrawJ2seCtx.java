/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.coredraw.j2se.ctx;

import java.awt.Font;
import java.io.InputStream;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.byteobjects.src4.ctx.BOCtx;
import pasa.cbentley.byteobjects.src4.ctx.IConfigBO;
import pasa.cbentley.core.j2se.ctx.J2seCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.coredraw.j2se.engine.FontCustomizerJ2SE;
import pasa.cbentley.framework.coredraw.src4.ctx.CoreDrawCtx;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechFont;

/**
 * Java SE defines the following five logical font families:
 * 
 * <li>{@link Font#DIALOG}
 * <li>{@link Font#DIALOG_INPUT}
 * <li>{@link Font#MONOSPACED}
 * <li>{@link Font#SERIF}
 * <li>{@link Font#SANS_SERIF}
 * 
 * Compared to the 3 from {@link ITechFont}
 * <li> {@link ITechFont#FACE_MONOSPACE}
 * <li> {@link ITechFont#FACE_PROPORTIONAL}
 * <li> {@link ITechFont#FACE_SYSTEM}
 * 
 * @author Charles Bentley
 *
 */
public abstract class CoreDrawJ2seCtx extends CoreDrawCtx {

   protected final J2seCtx j2c;

   public CoreDrawJ2seCtx(IConfigCoreDrawJ2se configDraw, J2seCtx j2c, BOCtx boc) {
      super(configDraw, boc);
      this.j2c = j2c;
   }

   public J2seCtx getJ2C() {
      return j2c;
   }

   public int getFeatureInt(int featureID) {
      return 0;
   }

   public IConfigCoreDrawJ2se getConfigCoreDrawJ2se() {
      return (IConfigCoreDrawJ2se) config;
   }

   /**
    * Returns the {@link FontCustomizerJ2SE} that is set
    * @return {@link FontCustomizerJ2SE}
    */
   public abstract FontCustomizerJ2SE getFontCustomizerJ2SE();

   public Object getFeatureObject(int featureID) {
      return null;
   }

   public boolean featureEnable(int featureID, boolean b) {
      switch (featureID) {
         case SUP_ID_06_CUSTOM_FONTS:
            //can we disable those?
            return true;
         case SUP_ID_07_IMAGE_SCALING:
            return true;
         case SUP_ID_10_TRANSPARENT_BACKGROUND:
            return true;
         default:
            break;
      }
      return false;
   }

   public boolean isFeatureEnabled(int featureID) {
      switch (featureID) {
         case SUP_ID_06_CUSTOM_FONTS:
            return true;
         case SUP_ID_07_IMAGE_SCALING:
            return true;
         case SUP_ID_10_TRANSPARENT_BACKGROUND:
            return true;
         default:
            break;
      }
      return false;
   }

   public boolean hasFeatureSupport(int featureID) {
      //#debug
      toDLog().pFlow("featureID=" + featureID + " ", this, CoreDrawJ2seCtx.class, "hasFeatureSupport", LVL_05_FINE, true);
      switch (featureID) {
         case SUP_ID_06_CUSTOM_FONTS:
            return true;
         case SUP_ID_07_IMAGE_SCALING:
            return true;
         case SUP_ID_10_TRANSPARENT_BACKGROUND:
            return true;
         default:
            break;
      }
      return false;
   }

   protected void matchConfig(IConfigBO config, ByteObject settings) {
      super.matchConfig(config, settings);
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, CoreDrawJ2seCtx.class);
      toStringPrivate(dc);
      super.toString(dc.sup());


   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, CoreDrawJ2seCtx.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }

   //#enddebug

}
