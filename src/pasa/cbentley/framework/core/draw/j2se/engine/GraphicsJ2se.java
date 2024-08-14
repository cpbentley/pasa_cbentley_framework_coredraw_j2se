/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.core.draw.j2se.engine;

import pasa.cbentley.core.src4.interfaces.ITechTransform;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.draw.j2se.ctx.CoreDrawJ2seCtx;
import pasa.cbentley.framework.coredraw.src4.engine.GraphicsAbstract;

public abstract class GraphicsJ2se extends GraphicsAbstract implements ITechTransform {

   protected GraphicsJ2se(CoreDrawJ2seCtx cac) {
      super(cac);
   }
   
   protected int getFontY_Baseline(FontJ2se font, int anchor, int y) {
      switch (anchor & (TOP | BOTTOM | BASELINE | VCENTER)) {
         case TOP:
            y += font.getAscent();
            break;
         case BOTTOM:
            y -= font.getDescent();
            break;
         case VCENTER:
            y += (font.getHeight() / 2) - font.getDescent();
            break;
         case BASELINE:
            //nothing to touch
            break;
      }
      return y;
   }
   
   protected int getFontY_Top(FontJ2se font, int anchor, int y) {
      switch (anchor & (TOP | BOTTOM | BASELINE | VCENTER)) {
         case TOP:
            //nothing to touch
            break;
         case BOTTOM:
            y -= font.getHeight();
            break;
         case VCENTER:
            y -= (font.getHeight() / 2);
            break;
         case BASELINE:
            y -= font.getAscent();
            break;
      }
      return y;
   }
   
   protected int getFontX(FontJ2se font, int anchor, int x, String str) {
      switch (anchor & (LEFT | RIGHT | HCENTER)) {
         case RIGHT:
            x -= font.stringWidth(str);
            break;
         case HCENTER:
            x -= (font.stringWidth(str) >> 1);
            break;
      }
      return x;
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, GraphicsJ2se.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, GraphicsJ2se.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   

}
