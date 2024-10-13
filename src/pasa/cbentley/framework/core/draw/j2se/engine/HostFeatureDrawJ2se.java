package pasa.cbentley.framework.core.draw.j2se.engine;

import pasa.cbentley.core.src4.interfaces.IHostFeature;
import pasa.cbentley.framework.core.draw.j2se.ctx.CoreDrawJ2seCtx;
import pasa.cbentley.framework.coredraw.src4.ctx.IBOCtxSettingsCoreDraw;
import pasa.cbentley.framework.coredraw.src4.ctx.ObjectCDC;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechGraphics;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechHostFeatureDraw;

/**
 * This class deals with all HostData, from Draw, UI and Core.
 * 
 * If you want a class limited to Draw, you 
 * @author Charles Bentley
 *
 */
public class HostFeatureDrawJ2se extends ObjectCDC implements IHostFeature, ITechHostFeatureDraw, IBOCtxSettingsCoreDraw {

   public HostFeatureDrawJ2se(CoreDrawJ2seCtx cdc) {
      super(cdc);
   }

   public boolean isHostFeatureEnabled(int featureID) {
      switch (featureID) {
         case SUP_ID_03_OPEN_GL:
            return false;
         case FEAT_02_ANTI_ALIAS:
            //globally
            return cdc.getBOCtxSettings().get1(CTX_COREDRAW_OFFSET_02_MODE_ALIAS1) != ITechGraphics.MODSET_APP_ALIAS_2_OFF;
         case FEAT_01_ANTI_ALIAS_TEXT:
            return cdc.getBOCtxSettings().get1(CTX_COREDRAW_OFFSET_03_MODE_TEXT_ALIAS1) != ITechGraphics.MODSET_APP_ALIAS_2_OFF;

         default:
            throw new IllegalArgumentException("Unknown FeatureID=" + featureID);
      }
   }

   public boolean isHostFeatureFactoryEnabled(int featureID) {
      switch (featureID) {
         case SUP_ID_03_OPEN_GL:
            return false;
         case FEAT_02_ANTI_ALIAS:
            //globally
            return cdc.getBOCtxSettings().get1(CTX_COREDRAW_OFFSET_02_MODE_ALIAS1) != ITechGraphics.MODSET_APP_ALIAS_2_OFF;
         case FEAT_01_ANTI_ALIAS_TEXT:
            return cdc.getBOCtxSettings().get1(CTX_COREDRAW_OFFSET_03_MODE_TEXT_ALIAS1) != ITechGraphics.MODSET_APP_ALIAS_2_OFF;
         default:
            throw new IllegalArgumentException("Unknown FeatureID=" + featureID);
      }
   }

   public boolean isHostFeatureSupported(int featureID) {
      switch (featureID) {
         case SUP_ID_03_OPEN_GL:
            return false;
         case FEAT_01_ANTI_ALIAS_TEXT:
         case FEAT_02_ANTI_ALIAS:
            return true;
         default:
            throw new IllegalArgumentException("Unknown FeatureID=" + featureID);
      }
   }

   public boolean applyAlias(boolean b) {
      //globally
      int value = ITechGraphics.MODSET_APP_ALIAS_2_OFF;
      cdc.getBOCtxSettings().set1(CTX_COREDRAW_OFFSET_02_MODE_ALIAS1, value);
      return true;
   }

   public boolean applyAliasText(boolean b) {
      //globally
      int value = ITechGraphics.MODSET_APP_ALIAS_2_OFF;
      cdc.getBOCtxSettings().set1(CTX_COREDRAW_OFFSET_03_MODE_TEXT_ALIAS1, value);
      return true;
   }

   public boolean setHostFeatureEnabled(int featureID, boolean b) {
      switch (featureID) {
         case SUP_ID_03_OPEN_GL:
            return false;
         case FEAT_02_ANTI_ALIAS:
            return applyAlias(b);
         case FEAT_01_ANTI_ALIAS_TEXT:
            return applyAliasText(b);
         default:
            throw new IllegalArgumentException("Unknown FeatureID=" + featureID);
      }
   }

   public boolean setHostFeatureEnabledFactory(int featureID, boolean b) {
      switch (featureID) {
         default:
            throw new IllegalArgumentException("Unknown FeatureID=" + featureID);
      }
   }

   public boolean setHostFeatureFactoryOff(int featureID) {
      return setHostFeatureEnabledFactory(featureID, false);
   }

   public boolean setHostFeatureFactoryOn(int featureID) {
      return setHostFeatureEnabledFactory(featureID, true);
   }

   public boolean setHostFeatureOff(int featureID) {
      return this.setHostFeatureEnabled(featureID, false);
   }

   public boolean setHostFeatureOn(int featureID) {
      return this.setHostFeatureEnabled(featureID, true);
   }

}
