package modelo;

public class Casilla {
	private boolean velada = true;
	private boolean marcada = false;
	private boolean mina = false;
	private int minasAlrededor = 0;

	public boolean isVelada() {
		return velada;
	}

	public void setVelada(boolean velada) {
		this.velada = velada;
	}

	public boolean isMarcada() {
		return marcada;
	}

	public void setMarcada(boolean marcada) {
		this.marcada = marcada;
	}

	public boolean isMina() {
		return mina;
	}

	public void setMina(boolean mina) {
		this.mina = mina;
	}

	public void setMinasAlrededor(int minasAlrededor) {
		this.minasAlrededor = minasAlrededor;
	}

	public int getMinasAlrededor() {
		return minasAlrededor;
	}

}
