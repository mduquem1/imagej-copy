package ij.gui;

public class RoiHelper {
	static void calculateDimensions(int x, int x2, int y, int y2, int width, int height, boolean center, int activeHandle, int xc, int yc) {
		if (x<x2)
			   width=x2-x;
			else
			  {width=1; x=x2;}
			if (y<y2)
			   height = y2-y;
			else
			   {height=1; y=y2;}
			if (center) {
				switch(activeHandle){
					case 0:
						width=(xc-x)*2;
						height=(yc-y)*2;
						break;
					case 1:
						height=(yc-y)*2;
						break;
					case 2:
						width=(x2-xc)*2;
						x=x2-width;
						height=(yc-y)*2;
						break;
					case 3:
						width=(x2-xc)*2;
						x=x2-width;
						break;
					case 4:
						width=(x2-xc)*2;
						x=x2-width;
						height=(y2-yc)*2;
						y=y2-height;
						break;
					case 5:
						height=(y2-yc)*2;
						y=y2-height;
						break;
					case 6:
						width=(xc-x)*2;
						height=(y2-yc)*2;
						y=y2-height;
						break;
					case 7:
						width=(xc-x)*2;
						break;
				}
				if (x>=x2) {
					width=1;
					x=x2=xc;
				}
				if (y>=y2) {
					height=1;
					y=y2=yc;
				}
			}
	}
	
	static void switchHandle(int activeHandle, int x2, int y2, int xc, int yc, int x, int y, int width, int height, boolean center)  {
		switch (activeHandle) {
		case 0:
			x=x2-width;
			y=y2-height;
			break;
		case 1:
			x=xc-width/2;
			y=y2-height;
			break;
		case 2:
			y=y2-height;
			break;
		case 3:
			y=yc-height/2;
			break;
		case 5:
			x=xc-width/2;
			break;
		case 6:
			x=x2-width;
			break;
		case 7:
			y=yc-height/2;
			x=x2-width;
			break;
}
	if (center) {
		x=xc-width/2;
		y=yc-height/2;
	}
	}
}
