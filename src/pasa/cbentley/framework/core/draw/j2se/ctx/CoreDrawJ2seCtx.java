/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.core.draw.j2se.ctx;

import java.awt.Font;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.byteobjects.src4.ctx.BOCtx;
import pasa.cbentley.byteobjects.src4.ctx.IConfigBO;
import pasa.cbentley.core.j2se.ctx.J2seCoreCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.draw.j2se.engine.FontCustomizerJ2se;
import pasa.cbentley.framework.core.draw.j2se.engine.HostDataDrawJ2se;
import pasa.cbentley.framework.core.draw.j2se.engine.HostFeatureDrawJ2se;
import pasa.cbentley.framework.core.draw.j2se.engine.HostServiceDrawJ2se;
import pasa.cbentley.framework.coredraw.src4.ctx.CoreDrawCtx;
import pasa.cbentley.framework.coredraw.src4.ctx.IConfigCoreDraw;
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

   protected final J2seCoreCtx j2c;

   public CoreDrawJ2seCtx(IConfigCoreDrawJ2se configDraw, J2seCoreCtx j2c, BOCtx boc) {
      super(configDraw, boc);
      this.j2c = j2c;
      //#mdebug
      if(configDraw == null) {
         throw new NullPointerException();
      }
      //#enddebug
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

   public IConfigCoreDrawJ2se getConfigCoreDrawJ2se() {
      return (IConfigCoreDrawJ2se) config;
   }

   public int getFeatureInt(int featureID) {
      return 0;
   }

   public Object getFeatureObject(int featureID) {
      return null;
   }

   /**
    * Returns the {@link FontCustomizerJ2se} that is set
    * @return {@link FontCustomizerJ2se}
    */
   public abstract FontCustomizerJ2se getFontCustomizerJ2SE();

   public abstract HostDataDrawJ2se getHostDataDrawJ2SE();

   public abstract HostFeatureDrawJ2se getHostFeatureDrawJ2se();

   public abstract HostServiceDrawJ2se getHostServiceDrawJ2se();

   public J2seCoreCtx getJ2C() {
      return j2c;
   }

   protected void matchConfig(IConfigBO config, ByteObject settings) {
      super.matchConfig(config, settings);
      IConfigCoreDrawJ2se configDraw = (IConfigCoreDrawJ2se) config;
      settings.set1(CTX_COREDRAW_OFFSET_02_MODE_ALIAS1, configDraw.getAliasMode());
      settings.set1(CTX_COREDRAW_OFFSET_03_MODE_TEXT_ALIAS1, configDraw.getAliasModeText());
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
