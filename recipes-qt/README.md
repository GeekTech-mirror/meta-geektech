## Qt Base
 - Configure backend for launching Qt apps
 	* use stock opengl for x11
 	* otherwise use eglfs if opengl is enabled
 - Add raspberry pi gpu support
 	* the raspberry pi may support one of two gpu drivers
	   vc4 and brcm
	 	* vc4 is a modern driver that's used by default. Only supports
	 	   64-bit on the raspberry pi 4
	 	* brcm is a older hardware specific driver. brcm does not support
	 	   64-bit OS.
	* If vc4graphics is enabled