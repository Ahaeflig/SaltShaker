package screens;

import screens.ContentDisplayer;

import com.accelerometer.AccelerometerTracker;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class SaltShakerScreen extends ApplicationAdapter implements Screen {
	
	private Game currentGame;
	
	private SpriteBatch batch;
	private Texture idleShaker;
	private Sprite idleShakerSprite;

	private TextureAtlas textureAtlas;
	private Animation animation;
	private AccelerometerTracker accelerometerTracker = AccelerometerTracker
			.getInstance();

	private float elapsedTime = 0;
	private float width;
	private float height;
	private boolean animated = false;
	private int animationFramCount = 9;
	
	
	public SaltShakerScreen(Game game) {
		this.currentGame = game;
		ContentDisplayer.getInstance().setGame(game);
	}
	
	@Override
	public void create() {
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();

		batch = new SpriteBatch();
		idleShaker = new Texture(Gdx.files.internal("images/saltshaker.jpg"));
		idleShakerSprite = new Sprite(idleShaker);

		textureAtlas = new TextureAtlas(
				Gdx.files.internal("animation/saltshakeranimation.atlas"));
		animation = new Animation(0.1f, textureAtlas.getRegions());
	}

	@Override
	public void render() {
		/*Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		if (accelerometerTracker.isShaking()) {
			animated = true;
		}
		
		if (animated) {
			elapsedTime += Gdx.graphics.getDeltaTime();
			batch.draw(animation.getKeyFrame(elapsedTime, true), 0, 0,
					width / 2, height / 2, width, height, 1f, 1f, 180);
			batch.end();
			
			System.out.println((animationFramCount  * 0.1f));
		
			if (elapsedTime > (animationFramCount  * 0.1f)) {
				animated = false;
				elapsedTime = 0;
				ContentDisplayer displayer = ContentDisplayer.getInstance();
				currentGame.setScreen(displayer);
				
			}
		} else {
			batch.draw(idleShakerSprite, 0, 0, width / 2, height / 2, width,
					height, 1f, 1f, 180);
			batch.end();
		}*/
	}

	@Override
	public void show() {
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();

		batch = new SpriteBatch();
		idleShaker = new Texture(Gdx.files.internal("images/saltshaker.jpg"));
		idleShakerSprite = new Sprite(idleShaker);

		textureAtlas = new TextureAtlas(
				Gdx.files.internal("animation/saltshakeranimation.atlas"));
		animation = new Animation(0.1f, textureAtlas.getRegions());
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		if (accelerometerTracker.isShaking()) {
			animated = true;
		}
		
		if (animated) {
			elapsedTime += delta;
			batch.draw(animation.getKeyFrame(elapsedTime, true), 0, 0,
					width / 2, height / 2, width, height, 1f, 1f, 180);
			batch.end();
			
			if (elapsedTime > (animationFramCount  * 0.1f)) {
				animated = false;
				elapsedTime = 0;
				ContentDisplayer displayer = ContentDisplayer.getInstance();
				currentGame.setScreen(displayer);
				
			}
		} else {
			batch.draw(idleShakerSprite, 0, 0, width / 2, height / 2, width,
					height, 1f, 1f, 180);
			batch.end();
		}
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
}
