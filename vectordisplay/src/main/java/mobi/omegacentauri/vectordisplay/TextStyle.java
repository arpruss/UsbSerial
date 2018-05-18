package mobi.omegacentauri.vectordisplay;

import mobi.omegacentauri.vectordisplay.VectorAPI.Buffer;
import mobi.omegacentauri.vectordisplay.VectorAPI.DisplayState;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class TextStyle extends Command {
	int x1,y1;
	
	public TextStyle(DisplayState state) {
		super(state);
	}

	@Override
	public int fixedArgumentsLength() {
		return 3;
	}

	@Override
	public DisplayState parseArguments(Context context, Buffer buffer) {
		state.align = (char)buffer.data[0];
		state.textSize = buffer.getInteger(1, 2);
		return state;
	}
	
	@Override
	public boolean doesDraw() {
		return false;
	}
}
