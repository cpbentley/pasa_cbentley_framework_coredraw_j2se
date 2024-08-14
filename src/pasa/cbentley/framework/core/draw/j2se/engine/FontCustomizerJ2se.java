package pasa.cbentley.framework.core.draw.j2se.engine;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.draw.j2se.ctx.CoreDrawJ2seCtx;
import pasa.cbentley.framework.coredraw.src4.engine.FontCustomizerAbstract;

public abstract class FontCustomizerJ2se extends FontCustomizerAbstract {

   private CoreDrawJ2seCtx cdjc;

   /**
    * 
    * @param cdc
    * @param factory
    */
   public FontCustomizerJ2se(CoreDrawJ2seCtx cdc, FontFactoryJ2se factory) {
      super(cdc, factory);
      cdjc = cdc;
   }

   protected String getDefaultFontNameMonoSub() {
      //from settings or config
      return cdjc.getConfigCoreDrawJ2se().getFontMonospace();
   }

   protected String getDefaultFontNamePropSub() {
      return cdjc.getConfigCoreDrawJ2se().getFontProportional();
   }

   protected String getDefaultFontNameSystemSub() {
      return cdjc.getConfigCoreDrawJ2se().getFontSystem();
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, FontCustomizerJ2se.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, FontCustomizerJ2se.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
