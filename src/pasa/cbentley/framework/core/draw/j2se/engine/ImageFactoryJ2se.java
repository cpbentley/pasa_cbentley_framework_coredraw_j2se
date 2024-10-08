/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.core.draw.j2se.engine;


import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.draw.j2se.ctx.CoreDrawJ2seCtx;
import pasa.cbentley.framework.coredraw.src4.engine.ImageFactoryAbstract;

public abstract class ImageFactoryJ2se extends ImageFactoryAbstract  {

   public ImageFactoryJ2se(CoreDrawJ2seCtx jcac) {
      super(jcac);

   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, ImageFactoryJ2se.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, ImageFactoryJ2se.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   

}
