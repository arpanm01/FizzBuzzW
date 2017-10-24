package com.prog.fizzbuzz.creators;

import com.prog.fizzbuzz.model.FizzBuzzVO;

public class FizzBuzzCreator {

	public FizzBuzzVO logicCreator(Integer cap){

		FizzBuzzVO fb = new FizzBuzzVO();

		for (int i=3;i<Integer.valueOf(cap)+1;i++)
		{
			if(i%3==0)
			{
				if(i%5==0){
					fb.getFizzbuzz().add(i);
				}else {
					fb.getFizz().add(i);
				}
			}
			else if (i%5==0){
				fb.getBuzz().add(i);
			}
		}
		return fb;
	}

}
