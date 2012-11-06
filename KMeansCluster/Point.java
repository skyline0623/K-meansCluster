package KMeansCluster;

import java.util.ArrayList;

class Point {
	protected double[] pos;
	protected int dimension;
	public Point(int size){
		pos = new double[size];
		this.dimension = size;
	}
	public Point(double[] p){
		this.pos = p;
		this.dimension = pos.length;
	}
	int getDimension(){
		return this.dimension;
	}
	
	double[] getPosition(){
		return pos.clone();
	}
	
	public static double euclideanDistance(Point p1, Point p2){
		if(p1.pos.length != p2.pos.length)
			return -1.0;
		double[] p = new double[p1.pos.length];
		for(int i = 0; i < p1.pos.length; ++i)
			p[i] = p1.pos[i] - p2.pos[i];
		double sum = 0.0;
		for(int i = 0; i < p1.pos.length; ++i){
			sum += Math.pow(p[i], 2.0);
		}
		return Math.sqrt(sum);
	}
	
	public static double squareDistance(Point p1, Point p2){
		if(p1.pos.length != p2.pos.length)
			return -1.0;
		double[] p = new double[p1.pos.length];
		for(int i = 0; i < p1.pos.length; ++i)
			p[i] = p1.pos[i] - p2.pos[i];
		double sum = 0.0;
		for(int i = 0; i < p1.pos.length; ++i){
			sum += Math.pow(p[i], 2.0);
		}
		return sum;
	}
	
	public boolean equals(Object o){
		Point p = (Point)o;
		if(this.dimension != p.dimension)
			return false;
		for(int i = 0; i < this.dimension; i++)
			if(this.pos[i] != p.pos[i])
				return false;
		return true;
	}
	public static void main(String[] args){
		double[] a = {1.0, 2.0, 3.0, 4.0}, b = {2.0, 3.0, 4.0, 2.0};
		Point p1 = new Point(a), p2 = new Point(b), p3 = new Point(a);
		ArrayList<Point> l = new ArrayList<Point>();
		l.add(p1);
		l.add(p2);
		System.out.println(l.contains(p3));
	}
}
