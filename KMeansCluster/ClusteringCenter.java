package KMeansCluster;

import java.util.ArrayList;

//每次迭代初始，clusterPoints为空，中心为新的mean点
class ClusteringCenter extends Point {
	private ArrayList<Integer> clusterPoints;
	private double[] sumOfPoints;
	ClusteringCenter(Point p){
		super(p.pos);
		clusterPoints = new ArrayList<Integer>();
		this.sumOfPoints = new double[this.dimension];
	}
	void addPointToCluster(int index){
		Point p = Process.INSTANCES.get(index);
		clusterPoints.add(index);
		double[] po = p.getPosition();
		for(int i = 0; i < this.dimension; ++i){
			sumOfPoints[i] += po[i];
		}
	}
	
	ClusteringCenter getNewCenter(){
		double[] pos = new double[Process.DIMENSION];
		for(int i = 0; i < this.dimension; ++i){
			pos[i] = sumOfPoints[i] / this.clusterPoints.size();
		}
		return new ClusteringCenter(new Point(pos));
	}
	
	double evaluate(){
		double ret = 0.0;
		for(int in : clusterPoints){
			ret += Point.squareDistance(Process.INSTANCES.get(in), this);
		}
		return ret;
	}
	ArrayList<Integer> belongedPoints(){
		return new ArrayList<Integer>(this.clusterPoints);
	}
}
