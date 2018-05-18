package mobi.omegacentauri.vectordisplay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.widget.Toast;

import mobi.omegacentauri.vectordisplay.VectorAPI.Buffer;
import mobi.omegacentauri.vectordisplay.VectorAPI.DisplayState;

public class PopupMessage extends Command {
	public PopupMessage(DisplayState state) {
		super(state);
	}
	
	@Override 
	public DisplayState parse(Context context, Buffer buffer, byte c) {
		if (buffer.length() >= 1 && c == 0) {
			String text = buffer.getString(0);
			Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
			return null;
		}
		else {
			buffer.put(c);		
			return null;
		}
	}
	
	@Override
	public DisplayState parse(Context context, Buffer buffer) {
		return null;
	}

}
