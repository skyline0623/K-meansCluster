1.The input dataset should have certain form:one line one instance,and neighboured feature should be splitted by space.
2.If you can change the maximum number of instances in a leaf node in the ball tree or the times of running the algorithm to find a better cluster for one specific k,change the conf.properties file in KMeansCluster.
3.The function you can use:
In the class Process:
	//gives your dataset's path and this function will build the internal data structures.	
	public static void loadData(String path) throws IOException;

	/**
	 * @param k  the initial number of clustering centers
	 * @return an entry:the key is the result of clustering.The label starts from 0.The value is the evaluation of the clustering result
	 */
	public static Entry<Integer[], Double> cluster(int k);

	/**gives the evaluation and differential of each k in specific range.you can use these infos to choose a good k for your clustering
	 * @param startK  gives the start point of k for the our try on k(inclusive)
	 * @param endK    gives the end point(exclusive)
	 * @return Entry's key is the evaluation of clustering of each k.The value is the differential of the evaluations--evaluation of k(i) - evaluation of k(i+1) for i in range(startK, endK - 1)
	 * */
	public static Entry<ArrayList<Double>, ArrayList<Double>> cluster(int startK, int endK);


Before call the last two functions,the first one must be called.

This repository has been migrated to my new account, conndots/KMeansCluster,https://github.com/conndots/KMeansCluster
