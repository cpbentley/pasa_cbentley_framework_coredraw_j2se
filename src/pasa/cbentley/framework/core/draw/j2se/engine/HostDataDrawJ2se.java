package pasa.cbentley.framework.core.draw.j2se.engine;

import pasa.cbentley.core.src4.interfaces.IHostData;
import pasa.cbentley.framework.core.draw.j2se.ctx.CoreDrawJ2seCtx;
import pasa.cbentley.framework.coredraw.src4.ctx.ObjectCDC;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechHostDataDraw;

/**
 * This class deals with all HostData, from Draw, UI and Core.
 * 
 * If you want a class limited to Draw, you 
 * @author Charles Bentley
 *
 */
public class HostDataDrawJ2se extends ObjectCDC implements IHostData, ITechHostDataDraw {

   public HostDataDrawJ2se(CoreDrawJ2seCtx cdc) {
      super(cdc);
   }

   public float getHostDataFloat(int dataID) {
      switch (dataID) {
         default:
            throw new IllegalArgumentException("Unknown dataID=" + dataID);
      }
   }

   public int getHostDataInt(int dataID) {
      switch (dataID) {
         default:
            throw new IllegalArgumentException("Unknown dataID=" + dataID);
      }
   }

   public Object getHostDataObject(int dataID) {
      switch (dataID) {
         default:
            throw new IllegalArgumentException("Unknown dataID=" + dataID);
      }
   }

   public String getHostDataString(int dataID) {
      switch (dataID) {
         case DATA_ID_STR_01_MANUFACTURER:
            return "";
         case DATA_ID_STR_02_IMEI:
            //depends
            return "00000000";
         case DATA_ID_STR_04_PLATFORM:
            return "J2SE";
         case DATA_ID_STR_03_DEVICE_MODEL:
            return System.getProperty("device.model");
         case DATA_ID_STR_06_ENCODING:
            return System.getProperty("file.encoding");
         default:
            throw new IllegalArgumentException("Unknown dataID=" + dataID);
      }
   }

}
