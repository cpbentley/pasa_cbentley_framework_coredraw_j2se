package pasa.cbentley.framework.core.draw.j2se.engine;

import pasa.cbentley.core.src4.interfaces.IHostService;
import pasa.cbentley.framework.core.draw.j2se.ctx.CoreDrawJ2seCtx;
import pasa.cbentley.framework.coredraw.src4.ctx.ObjectCDC;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechHostServiceDraw;

public class HostServiceDrawJ2se extends ObjectCDC implements IHostService, ITechHostServiceDraw {

   public HostServiceDrawJ2se(CoreDrawJ2seCtx cdc) {
      super(cdc);
   }

   public boolean isHostServiceActive(int serviceID) {
      switch (serviceID) {
         default:
            throw new IllegalArgumentException("Unknown serviceID = " + serviceID);
      }
   }

   public boolean isHostServiceSupported(int serviceID) {
      switch (serviceID) {
         default:
            throw new IllegalArgumentException("Unknown serviceID = " + serviceID);
      }
   }

   public boolean setHostServiceActive(int serviceID, boolean isActive) {
      switch (serviceID) {
         default:
            throw new IllegalArgumentException("Unknown serviceID = " + serviceID);
      }
   }

   public boolean setHostServiceOff(int serviceID) {
      return setHostServiceActive(serviceID, false);
   }

   public boolean setHostServiceOn(int serviceID) {
      return setHostServiceActive(serviceID, true);
   }

}
