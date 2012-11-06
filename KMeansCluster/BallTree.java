package KMeansCluster;

class BallTree {
	//When call this function, the parameter should be null
	static Hypersphere buildAnInstance(Hypersphere cur){
		if(cur == null){
			cur = new Hypersphere();
			for(int i = 0; i < Process.INSTANCES.size(); ++i){
				cur.addInstance(i);
			}
			cur.endAdding();
		}
		Hypersphere[] ch = cur.split();
		for(Hypersphere hp : ch){
			if(hp.size() <= Process.MAX_INSTANCE_NUM_NOT_SPLIT){
				continue;
			}
			buildAnInstance(hp);
		}
		return cur;
	}
}
