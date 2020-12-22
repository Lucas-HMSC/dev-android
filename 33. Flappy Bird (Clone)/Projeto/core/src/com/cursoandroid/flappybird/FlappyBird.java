package com.cursoandroid.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

public class FlappyBird extends ApplicationAdapter {

	private SpriteBatch batch;
	private Texture passaro[];
	private Texture fundo;
	private Texture canoBaixo;
	private Texture canoTopo;
	private Texture gameOver;
	private Random aleatorio;
	private BitmapFont fonte;
	private BitmapFont mensagem;
	private Circle passaroCirculo;
	private Rectangle canoTopoRect;
	private Rectangle canoBaixoRect;
	//private ShapeRenderer shape;

	// Atributos de Configuração
	private float larguraDispositivo;
	private float alturaDispositivo;
	private int estadoJogo = 0; // 0 para não iniciado -- 1 para iniciado -- 2 para game over
	private int pontuacao = 0;

	private float variacao = 0;
	private float velocidadeQueda = 0;
	private float posicaoVerticalPassaro;
	private float posicaoMovimentoCanoHorizontal;
	private float espacoEntreCanos;
	private float deltaTime;
	private float alturaEntreCanosRandom;

	private boolean marcouPonto = false;

	// Camera
	private OrthographicCamera camera;
	private Viewport viewport;
	private final float VIRTUAL_WIDTH = 768;
	private final float VIRTUAL_HEIGHT = 1024;

	@Override
	public void create () {
		batch = new SpriteBatch();
		aleatorio = new Random();
		passaroCirculo = new Circle();
		//canoTopoRect = new Rectangle();
		//canoBaixoRect = new Rectangle();
		//shape = new ShapeRenderer();
		fonte = new BitmapFont();
		fonte.setColor(Color.WHITE);
		fonte.getData().setScale(6);

		mensagem = new BitmapFont();
		mensagem.setColor(Color.WHITE);
		mensagem.getData().setScale(3);

		passaro = new Texture[3];
		passaro[0] = new Texture("passaro1.png");
		passaro[1] = new Texture("passaro2.png");
		passaro[2] = new Texture("passaro3.png");
		fundo = new Texture("fundo.png");
		canoBaixo = new Texture("cano_baixo.png");
		canoTopo = new Texture("cano_topo.png");
		gameOver = new Texture("game_over.png");

		// Configuração da Camera
		camera = new OrthographicCamera();
		camera.position.set(VIRTUAL_WIDTH / 2, VIRTUAL_HEIGHT / 2, 0);
		viewport = new StretchViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);

		larguraDispositivo = VIRTUAL_WIDTH;
		alturaDispositivo = VIRTUAL_HEIGHT;

		posicaoVerticalPassaro = alturaDispositivo / 2;
		posicaoMovimentoCanoHorizontal = larguraDispositivo;
		espacoEntreCanos = 300;
	}

	@Override
	public void render () {

		camera.update();

		// Limpa os frames anteriores
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		deltaTime = Gdx.graphics.getDeltaTime();
		variacao += deltaTime * 10;
		if (variacao > 2) {
			variacao = 0;
		}

		if (estadoJogo == 0){ //Não iniciado
			if (Gdx.input.justTouched()){
				estadoJogo = 1;
			}
		} else { // Iniciado

			velocidadeQueda++;
			if (posicaoVerticalPassaro > 0 || velocidadeQueda < 0) {
				posicaoVerticalPassaro -= velocidadeQueda;
			}


			if (estadoJogo == 1) {
				posicaoMovimentoCanoHorizontal -= deltaTime * 400;

				if (Gdx.input.justTouched()) {
					velocidadeQueda = -20;
				}

				// Verifica se o cano saiu inteiramente da tela
				if (posicaoMovimentoCanoHorizontal < -(canoTopo.getWidth())) {
					posicaoMovimentoCanoHorizontal = larguraDispositivo;
					alturaEntreCanosRandom = aleatorio.nextInt(400 - 200);
					marcouPonto = false;
				}

				// Verifica pontuação
				if (posicaoMovimentoCanoHorizontal < 120) {
					if (!marcouPonto) {
						pontuacao++;
						marcouPonto = true;
					}
				}
			} else { // Game Over
				if (Gdx.input.justTouched()){
					estadoJogo = 0;
					pontuacao = 0;
					velocidadeQueda = 0;
					posicaoVerticalPassaro = alturaDispositivo / 2;
					posicaoMovimentoCanoHorizontal = larguraDispositivo;
				}
			}
		}

		// Configurar dados de projeção da câmera
		batch.setProjectionMatrix(camera.combined);

		batch.begin();

		batch.draw(fundo, 0, 0, larguraDispositivo, alturaDispositivo);
		batch.draw(canoTopo, posicaoMovimentoCanoHorizontal, alturaDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandom);
		batch.draw(canoBaixo, posicaoMovimentoCanoHorizontal, alturaDispositivo / 2 - canoBaixo.getHeight() - espacoEntreCanos / 2 + alturaEntreCanosRandom);
		batch.draw(passaro[(int) variacao], 120, posicaoVerticalPassaro);
		fonte.draw(batch, String.valueOf(pontuacao), (larguraDispositivo / 2) - 12, alturaDispositivo - 50);

		if (estadoJogo == 2){
			batch.draw(gameOver, larguraDispositivo / 2 - (gameOver.getWidth() / 2), alturaDispositivo / 2 - (gameOver.getHeight() / 2));
			mensagem.draw(batch, "Toque para Reiniciar", larguraDispositivo / 2 - 200, alturaDispositivo / 2 - gameOver.getHeight() / 2);
		}

		batch.end();

		// Desenho das formas
		passaroCirculo.set(120 + (passaro[0].getWidth() / 2), posicaoVerticalPassaro + (passaro[0].getHeight() / 2) ,passaro[0].getWidth() / 2);
		canoBaixoRect = new Rectangle(
				posicaoMovimentoCanoHorizontal, alturaDispositivo / 2 - canoBaixo.getHeight() - espacoEntreCanos / 2 + alturaEntreCanosRandom,
				canoBaixo.getWidth(), canoBaixo.getHeight()
		);
		canoTopoRect = new Rectangle(
				posicaoMovimentoCanoHorizontal, alturaDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandom,
				canoTopo.getWidth(), canoTopo.getHeight()
		);
		/*
		shape.begin(ShapeRenderer.ShapeType.Filled);
		shape.circle(passaroCirculo.x, passaroCirculo.y, passaroCirculo.radius);
		shape.rect(canoBaixoRect.x, canoBaixoRect.y, canoBaixoRect.width, canoBaixoRect.height);
		shape.rect(canoTopoRect.x, canoTopoRect.y, canoTopoRect.width, canoTopoRect.height);
		shape.setColor(Color.RED);
		shape.end();*/

		// Teste de Colisão
		if (Intersector.overlaps(passaroCirculo, canoBaixoRect) ||
			Intersector.overlaps(passaroCirculo, canoTopoRect) ||
			posicaoVerticalPassaro <= 0 ||
			posicaoVerticalPassaro >= alturaDispositivo){
			estadoJogo = 2;
		}
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}
}
