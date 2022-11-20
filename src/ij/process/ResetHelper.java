package ij.process;

public class ResetHelper {
	public void resetDefault(short[] pixels, short[] snapshotPixels, int width, int height, int min,
			int max, int snapshotMin, int snapshotMax, boolean minMaxSet) {
		if (snapshotPixels==null)
			return;
	    min=snapshotMin;
		max=snapshotMax;
		minMaxSet = true;
        System.arraycopy(snapshotPixels, 0, pixels, 0, width*height);
	}
	
	public void resetFloat(float[] pixels, float[] snapshotPixels, int width, int height, float min,
			float max, float snapshotMin, float snapshotMax, boolean minMaxSet) {
		if (snapshotPixels==null)
			return;
	    min=snapshotMin;
		max=snapshotMax;
		minMaxSet = true;
        System.arraycopy(snapshotPixels, 0, pixels, 0, width*height);
	}
	
	public static Object resetWithImage(ImageProcessor mask, short[] pixels, short[] snapshotPixels,  int roiWidth, int roiHeight, int roiX, int roiY, int width, int height) {
		if (mask==null || snapshotPixels==null)
			return new Object();	
		if (mask.getWidth()!=roiWidth||mask.getHeight()!=roiHeight)
			throw new IllegalArgumentException("Mask error");
		byte[] mpixels = (byte[])mask.getPixels();
		for (int y=roiY, my=0; y<(roiY+roiHeight); y++, my++) {
			int i = y * width + roiX;
			int mi = my * roiWidth;
			for (int x=roiX; x<(roiX+roiWidth); x++) {
				if (mpixels[mi++]==0)
					pixels[i] = snapshotPixels[i];
				i++;
			}
		}
		return mpixels;
	}
}
