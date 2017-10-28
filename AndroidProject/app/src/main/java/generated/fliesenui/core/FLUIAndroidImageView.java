package generated.fliesenui.core;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FLUIAndroidImageView extends View {
	public enum Direction{LEFT, RIGHT}

	private Integer backgroundColor = null;
    private Bitmap bitmap = null;
    private Integer labelOuterColor = null;
    private int labelInnerColor = 0;
    private float labelFontSize = 0;
    private String labelText = null;
    private int labelPosX = 0;
    private int labelPosY = 0;
    private boolean navigationArrowsEnabled = false;
	private Activity activity;
    private boolean navigationArrowsFadeInTimerRunning = false;
    private boolean navigationArrowsFadeOutTimerRunning = false;
    private float navigationArrowsVisibleFactor = 0f;
    private List<EasyImageViewNavigationListener> navigationListeners = new ArrayList<EasyImageViewNavigationListener>();
	private long lastTouchTime = 0;
	private OnClickListener onClickListener = null;
	private Integer fixedWidth = null;
	private Integer fixedHeight = null;
	private int borderWidth = 0;
	private Integer borderColor = null;


    public interface EasyImageViewNavigationListener {
        public void navigationActionPerformed(Direction direction);
    }


    public FLUIAndroidImageView(Activity activity, Bitmap bitmap, Integer backgroundColor) {
        super(activity);
        this.activity = activity;
        this.bitmap = bitmap;
        this.backgroundColor = backgroundColor;
        
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (navigationArrowsEnabled) checkNavigationArrowsFadeOutTimerActionPerformed();
            }
        }, 0, 1000);
    }
    
    public FLUIAndroidImageView(Activity activity, int resourceID, Integer backgroundColor) throws Exception {
    	this(activity, FLUIAndroidUtil.loadImage(activity.getResources(), resourceID), backgroundColor);
    }
    
    public void addNavigationListener(EasyImageViewNavigationListener listener){
    	navigationListeners.add(listener);
    }
    
    public void setNavigationArrowsEnabled(boolean navigationArrowsEnabled){
    	this.navigationArrowsEnabled = navigationArrowsEnabled;
    }
    
    public FLUIAndroidImageView(Activity activity) {
    	this(activity, null, Color.WHITE);
    }
    
    public void setOnClickListener(OnClickListener listener){
    	this.onClickListener = listener;
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Style.FILL);
        paint.setAntiAlias(true);
        if (backgroundColor != null){
        	paint.setColor(backgroundColor);
        	canvas.drawPaint(paint);
        }
        
        double innerWidth = getWidth() - (borderWidth * 2);
        double innerHeight = getHeight() - (borderWidth * 2);
        
        if (bitmap != null){
        	double factorX = innerWidth / ((double)bitmap.getWidth());
        	double factorY = innerHeight / ((double)bitmap.getHeight());
        	double usedFactor = Math.min(factorX, factorY);
        	double newWidth = ((double)bitmap.getWidth()) * usedFactor;
        	double newHeight = ((double)bitmap.getHeight()) * usedFactor;
        	int offsetX = (int) ((innerWidth - newWidth) / 2);
        	int offsetY = (int) ((innerHeight - newHeight) / 2);
        	
        	canvas.drawBitmap(bitmap, null, new Rect(offsetX, offsetY, offsetX + (int)newWidth, offsetY + (int)newHeight), paint);
        }
        
        if (navigationArrowsEnabled) drawNavigationArrows(canvas);
        
        if ((labelText != null) && (labelText.length() > 0)){
            paint.setTextSize(labelFontSize);
            
            FontMetricsInt metrics = paint.getFontMetricsInt();
            FLUIAndroidUtil.drawAndWrapTextBelowWithOutline(labelText, labelPosX, labelPosY, getWidth(), canvas, paint, metrics, false, false
            		                                         , labelInnerColor, labelOuterColor);
        }
        
        if ((borderWidth > 0) && (borderColor != null)){
        	paint.setStyle(Style.STROKE);
        	paint.setColor(borderColor);
        	paint.setStrokeWidth(borderWidth);
        	canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
//        	canvas.drawRect(getWidth() - borderWidth, 0, getWidth(), getHeight(), paint);
//        	canvas.drawRect(0, 0, borderWidth, getHeight(), paint);
        }
    }
    
    private int calculateNavigationArrowAreaWidth(){
    	return getWidth() / 8;
    }
    
    private void drawNavigationArrows(Canvas canvas) {
    	int areaWidth = calculateNavigationArrowAreaWidth();
    	int arrowHeight = (int)FLUIAndroidUtil.getPixelWidthForCM(activity, 4);
    	int arrowPaddingX = areaWidth / 4;
    	int arrowPaddingY = (getHeight() / 2) - (arrowHeight / 2);
    	
    	int backgroundColor = Color.argb((int) (176f * navigationArrowsVisibleFactor), 128, 128, 128);
    	int arrowColor = Color.argb((int) (176f * navigationArrowsVisibleFactor), 86, 86, 86);
    	int arrowOutlineColor = Color.argb((int) (176 * navigationArrowsVisibleFactor), 0, 0, 0);
    	
    	Paint paint = new Paint();
    	paint.setColor(backgroundColor);
    	paint.setStyle(Style.FILL);
    	canvas.drawRect(0, 0, areaWidth, getHeight(), paint);
    	canvas.drawRect(getWidth() - areaWidth, 0, getWidth(), getHeight(), paint);

    	Path path = new Path();
    	path.moveTo(areaWidth - arrowPaddingX, arrowPaddingY);
    	path.lineTo(arrowPaddingX, getHeight() / 2);
    	path.lineTo(areaWidth - arrowPaddingX, getHeight() - arrowPaddingY);
    	path.close();
        FLUIAndroidUtil.drawPathWithOutline(canvas, path, arrowColor, arrowOutlineColor);
    	
    	path = new Path();
    	path.moveTo(getWidth() - areaWidth + arrowPaddingX, arrowPaddingY);
    	path.lineTo(getWidth() - arrowPaddingX, getHeight() / 2);
    	path.lineTo(getWidth() - areaWidth + arrowPaddingX, getHeight() - arrowPaddingY);
    	path.close();
        FLUIAndroidUtil.drawPathWithOutline(canvas, path, arrowColor, arrowOutlineColor);
	}
    

	public void openImage(File path) throws Exception {
        InputStream is = null;
        try{
            is = new FileInputStream(path);
            openImage(is);
        } catch (Exception e){
            throw e;
        } finally {
            if (is != null) is.close();
        }
    }

    public void openImage(InputStream inputStream) throws Exception {
        bitmap = BitmapFactory.decodeStream(inputStream);
        redraw();
    }
    
    public void openImage(Resources resources, int resourceID) throws Exception {
        InputStream inputStream = null;
        try{
            inputStream = resources.openRawResource(resourceID);
            bitmap = BitmapFactory.decodeStream(inputStream);
            redraw();
        } catch (Exception e){
            throw e;
        } finally {
            if (inputStream != null) inputStream.close();
        }
    }
    
    private void redraw(){
        try{
            postInvalidate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

	public void setImage(Bitmap bitmap) {
		this.bitmap = bitmap;
		redraw();
	}

	public void setLabelOuterColor(Integer labelOuterColor) {
		this.labelOuterColor = labelOuterColor;
	}

	public void setLabelInnerColor(int labelInnerColor) {
		this.labelInnerColor = labelInnerColor;
	}

	public void setLabelFontSize(float labelFontSize) {
		this.labelFontSize = labelFontSize;
	}

	public void setLabelText(String labelText) {
		this.labelText = labelText;
	}

	public void setLabelPosY(int labelPosY) {
		this.labelPosY = labelPosY;
	}

	public void setLabelPosX(int labelPosX) {
		this.labelPosX = labelPosX;
	}
	
    private void startNavigationArrowsFadeOutTimer() {
        if (navigationArrowsFadeInTimerRunning) return;
        navigationArrowsFadeOutTimerRunning = true;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                navigationArrowsFadeOutTimerActionPerformed();
            }
        }, 100);
    }
    
    private void navigationArrowsFadeOutTimerActionPerformed() {
        navigationArrowsVisibleFactor -= 0.1;
        if (navigationArrowsVisibleFactor <= 0){
            navigationArrowsFadeOutTimerRunning = false;
            navigationArrowsVisibleFactor = 0;
        } else {
            startNavigationArrowsFadeOutTimer();
        }
        redraw();
    }    
    
    private void startNavigationArrowsFadeInTimer() {
      navigationArrowsFadeInTimerRunning = true;
      new Timer().schedule(new TimerTask() {
          @Override
          public void run() {
              navigationArrowsFadeInTimerActionPerformed();
          }
      }, 200);
  }

  private void navigationArrowsFadeInTimerActionPerformed() {
      navigationArrowsVisibleFactor += 0.1;
      if (navigationArrowsVisibleFactor >= 1){
          navigationArrowsFadeInTimerRunning = false;
          navigationArrowsVisibleFactor = 1;
      } else {
          startNavigationArrowsFadeInTimer();
      }
      try{
          redraw();
      } catch (Exception ignore){}
  }

  private void checkNavigationArrowsFadeOutTimerActionPerformed(){
    if (   (System.currentTimeMillis() - lastTouchTime > 6000)
        && (navigationArrowsVisibleFactor == 1) 
        && (!navigationArrowsFadeOutTimerRunning)) {
        startNavigationArrowsFadeOutTimer();
    }
}
	
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	if (onClickListener != null) onClickListener.onClick(this);
    	if (!navigationArrowsEnabled) return false;
        boolean touch = (event.getAction() == MotionEvent.ACTION_DOWN);
        boolean drag = (event.getAction() == MotionEvent.ACTION_MOVE);
        if (touch || drag){
        	lastTouchTime = System.currentTimeMillis();
        	
        	if ((navigationArrowsVisibleFactor < 1) && (!navigationArrowsFadeInTimerRunning)) startNavigationArrowsFadeInTimer();
        	
        	int areaSize = calculateNavigationArrowAreaWidth();
        	if (event.getX() < areaSize) navigationActionPerformed(Direction.LEFT);
        	else if (event.getX() > getWidth() - areaSize) navigationActionPerformed(Direction.RIGHT);
        	
        }
        return false;
    }

	private void navigationActionPerformed(Direction direction) {
		for (EasyImageViewNavigationListener i: navigationListeners){
			i.navigationActionPerformed(direction);
		}
	}

	public void setImageResource(Context context, int resourceID) throws Exception {
		bitmap = FLUIAndroidUtil.loadImage(context.getResources(), resourceID);
	}
	
	/**
	 * if the size is set by this method, the default behaviour is overwritten to use the given size
	 */
	public void setFixedSize(int width, int height) {
		this.fixedWidth = width;
		this.fixedHeight = height;
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		if (fixedWidth == null){ //: no fixed measure has been set. Use default behavior
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
			return;
		} 
		setMeasuredDimension(fixedWidth, fixedHeight);
	}
	
	public void setBorder(int width, int color){
		borderWidth = width;
		borderColor = color;
	}
	
	@Override
	public void setBackgroundColor(int color) {
		backgroundColor = color;
		redraw();
	}
}
