/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.core.draw.j2se.engine;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.draw.j2se.ctx.CoreDrawJ2seCtx;
import pasa.cbentley.framework.coredraw.src4.engine.ImageAbstract;

public abstract class ImageJ2se extends ImageAbstract {

   /** 
    * Image mutability flag
    */
   protected boolean isMutable = false;

   protected int     colorBackground;

   /**
    * Flags to be used on Graphics.
    */
   protected int     renderingFlags;

   protected boolean isEmpty;

   //#debug
   protected String    toStringNameDebug;

   protected ImageJ2se(CoreDrawJ2seCtx cac) {
      super(cac);
   }

   public boolean isMutable() {
      return isMutable;
   }

   public void setMutable(boolean b) {
      isMutable = b;
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, ImageJ2se.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
      dc.line();
      dc.appendVarWithSpace("toStringNameDebug", toStringNameDebug);
   }

   private void toStringPrivate(Dctx dc) {
      dc.appendVarWithSpace("isMutable", isMutable);
      dc.appendVarWithSpace("isEmpty", isEmpty);
      dc.appendVarWithSpace("colorBackground", colorBackground);
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, ImageJ2se.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
