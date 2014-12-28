package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gifconverter.GifDecoder;

public class ContentDisplayer extends ScreenAdapter {

	private ContentDisplayer() {
		batch = new SpriteBatch();
		anim = GifDecoder.loadGIFAnimation(Gdx.files.internal(
				ContentPathName.legolyes).read());
	}

	private static ContentDisplayer INSTANCE = new ContentDisplayer();

	public static ContentDisplayer getInstance() {
		return INSTANCE;
	}

	private Animation anim;
	private SpriteBatch batch;

	private float frameCounter = 0;
	private int width = Gdx.graphics.getWidth();
	private int height = Gdx.graphics.getHeight();
	private Game game;

	@Override
	public void show() {
		Gdx.input.setCatchBackKey(true);
		
		// TODO chose random content
		frameCounter = 0;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
			((Game) Gdx.app.getApplicationListener()).setScreen(new SaltShakerScreen(game));
		}
			
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		frameCounter += delta;
		batch.draw(anim.getKeyFrame(frameCounter, true), 0, 0, width / 2,
				height / 2, width, height, 1f, 1f, 90);

		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
