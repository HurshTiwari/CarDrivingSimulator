package textures;

public class TerrainTexturePack {
	
	private TerrainTexture backgroundTexture;
	private TerrainTexture rTexture;
	public TerrainTexturePack(TerrainTexture backgroundTexture, TerrainTexture rTexture) {
		this.backgroundTexture = backgroundTexture;
		this.rTexture = rTexture;
	}
	public TerrainTexture getBackgroundTexture() {
		return backgroundTexture;
	}
	public TerrainTexture getrTexture() {
		return rTexture;
	}
	
	
	

}
