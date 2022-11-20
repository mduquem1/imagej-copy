package ij.process;

public class CentroidHelper extends ImageStatistics {
	
	void getCentroid(ImageProcessor ip, int minThreshold, int maxThreshold) {
		byte[] pixels = (byte[])ip.getPixels();
		byte[] mask = ip.getMaskArray();
		boolean limit = minThreshold>0 || maxThreshold<255;
		double xsum=0, ysum=0;
		int count=0,i,mi,v;
		for (int y=ry,my=0; y<(ry+rh); y++,my++) {
			i = y*width + rx;
			mi = my*rw;
			for (int x=rx; x<(rx+rw); x++) {
				if (mask==null||mask[mi++]!=0) {
					if (limit) {
						v = pixels[i]&255;
						if (v>=minThreshold&&v<=maxThreshold) {
							count++;
							xsum+=x;
							ysum+=y;
						}
					} else {
						count++;
						xsum+=x;
						ysum+=y;
					}
				}
				i++;
			}
		}
		xCentroid = xsum/count+0.5;
		yCentroid = ysum/count+0.5;
		if (cal!=null) {
			xCentroid = cal.getX(xCentroid);
			yCentroid = cal.getY(yCentroid, height);
		}
	}

}
