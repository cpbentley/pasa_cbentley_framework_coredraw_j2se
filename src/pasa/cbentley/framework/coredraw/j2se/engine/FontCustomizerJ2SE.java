package pasa.cbentley.framework.coredraw.j2se.engine;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.coredraw.j2se.ctx.CoreDrawJ2seCtx;
import pasa.cbentley.framework.coredraw.src4.engine.FontCustomizerAbstract;

public abstract class FontCustomizerJ2SE extends FontCustomizerAbstract {

   private CoreDrawJ2seCtx cdjc;
   public FontCustomizerJ2SE(CoreDrawJ2seCtx cdc, FontFactoryJ2SE factory) {
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
      dc.root(this, FontCustomizerJ2SE.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, FontCustomizerJ2SE.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   

}
