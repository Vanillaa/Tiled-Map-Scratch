package com.laz.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TiledScratch extends ApplicationAdapter implements InputProcessor{
	Texture img;
	TiledMap testmap;
	OrthographicCamera camera;
	TiledMapRenderer tiledMapRenderer;
	int nTileHeight, nTileWidth,nMapHeight, nMapWidth;
	TiledMapTileLayer layer;
	@Override
	public void create () {
		float fwidth = Gdx.graphics.getWidth();
		float fheight = Gdx.graphics.getHeight();
		testmap = new TmxMapLoader().load("testmap.tmx");
		layer=(TiledMapTileLayer) testmap.getLayers().get(0);
		nMapHeight=layer.getHeight()*nTileHeight;
		nMapWidth=layer.getWidth()*nTileWidth;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, fwidth, fheight);
		//camera.setToOrtho(false, nMapWidth, nMapHeight);


		tiledMapRenderer = new OrthogonalTiledMapRenderer(testmap);
		Gdx.input.setInputProcessor(this);
		camera.update();
	}

	@Override
	public void render () {
	//	Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Input.Keys.LEFT)
			camera.translate(-32,0);
		if(keycode == Input.Keys.RIGHT)
			camera.translate(32,0);
		if(keycode == Input.Keys.UP)
			camera.translate(0,-32);
		if(keycode == Input.Keys.DOWN)
			camera.translate(0,32);
		if(keycode == Input.Keys.NUM_1)
			testmap.getLayers().get(0).setVisible(!testmap.getLayers().get(0).isVisible());
		if(keycode == Input.Keys.NUM_2)
			testmap.getLayers().get(1).setVisible(!testmap.getLayers().get(1).isVisible());

		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
