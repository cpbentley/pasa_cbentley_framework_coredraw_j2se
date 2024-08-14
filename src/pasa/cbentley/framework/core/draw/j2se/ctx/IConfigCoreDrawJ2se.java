/*
 * (c) 2018-2020 Charles-Philip Bentley
 * This code is licensed under MIT license (see LICENSE.txt for details)
 */
package pasa.cbentley.framework.core.draw.j2se.ctx;

import pasa.cbentley.framework.coredraw.src4.ctx.IConfigCoreDraw;
import pasa.cbentley.framework.coredraw.src4.interfaces.IFontFactory;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechGraphics;

public interface IConfigCoreDrawJ2se extends IConfigCoreDraw {

   /**
    * 
    * @return
    */
   public int getFontPoint_01_Tiny();

   /**
    * 
    * @return
    */
   public int getFontPoint_02_Small();

   /**
    * 
    * @return
    */
   public int getFontPoint_03_Medium();

   /**
    * 
    * @return
    */
   public int getFontPoint_04_Large();

   /**
    * 
    * @return
    */
   public int getFontPoint_05_Huge();

   /**
    * {@link IFontFactory#getFontPointExtraShift()}
    * 
    * @return
    */
   public int getFontPointsExtraShift();

   /**
    * <li> {@link ITechGraphics#MODSET_APP_ALIAS_0_BEST}
    * <li> {@link ITechGraphics#MODSET_APP_ALIAS_1_ON}
    * <li> {@link ITechGraphics#MODSET_APP_ALIAS_2_OFF}
    * @return
    */
   public int getAliasMode();

   /**
    * 
    * @return
    */
   public int getAliasModeText();

   public String getFontMonospace();

   public String getFontSystem();

   public String getFontProportional();

}
