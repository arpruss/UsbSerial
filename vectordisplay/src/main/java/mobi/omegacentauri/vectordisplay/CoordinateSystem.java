package mobi.omegacentauri.vectordisplay;

import mobi.omegacentauri.vectordisplay.VectorAPI.Buffer;
import mobi.omegacentauri.vectordisplay.VectorAPI.DisplayState;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.Log;

public class CoordinateSystem extends Command {
	public CoordinateSystem(DisplayState state) {
		super(state);
	}
	
	@Override 
	public DisplayState parse(Context context, Buffer buffer, byte c) {
		buffer.put(c);
		if (buffer.length() >= 5) {
			state.width = buffer.getInteger(0, 2);
			state.height = buffer.getInteger(2, 2);
			Log.v("VectorDisplay", "coordinate "+state.width+" "+state.height);
			state.fit = buffer.data[4] != 0;
			return state;
		}
		return null;
	}
	
	@Override
	public DisplayState parse(Context context, Buffer buffer) {
		return null;
	}

	@Override
	public boolean doesDraw() {
		return false;
	}
}
