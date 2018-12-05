package cn.ed.qut.compiler.zhg.test;

import java.util.ArrayList;
import java.util.List;

import cn.ed.qut.compiler.base.intermediateCodeGeneration.FourElement;
import cn.ed.qut.compiler.zhg.objectCodeGeneration.BaseBlock;
import cn.ed.qut.compiler.zhg.objectCodeGeneration.ObjectCodeGenerater;
import cn.ed.qut.compiler.zhg.objectCodeGeneration.concrete.risc.mips.MIPSGenerator;
import cn.ed.qut.compiler.zhg.tools.FileReadUtil;

public class Test {
	public static void main(String[] args) throws Exception {
		ArrayList<FourElement> fourElements=new ArrayList<>();
		fourElements.add(new FourElement(0,"CALL",null,null,"main",0));
		fourElements.add(new FourElement(1,"GOTO",null,null,"(29)",0));
		fourElements.add(new FourElement(2,"ASSIGN","0",null,"sum",0)); 
		fourElements.add(new FourElement(3,"ASSIGN","5",null,"a",0));  
		fourElements.add(new FourElement(4,"ASSIGN","4",null,"b",0));
		fourElements.add(new FourElement(5,"ASSIGN","1",null,"i",0) );
		fourElements.add(new FourElement(6,"JB","i","11","(8)",1) );
		fourElements.add(new FourElement(7,"GOTO",null,null,"(20)",1) );
		fourElements.add(new FourElement(8,"+","sum","i","T1",1) );
		fourElements.add(new FourElement(9,"ASSIGN","T1",null,"sum",1) );
		fourElements.add(new FourElement(10,"ASSIGN","1",null,"i",1) );
		fourElements.add(new FourElement(11,"JB","i","11","(13)",2) );
		fourElements.add(new FourElement(12,"GOTO",null,null,"(18)",2));
		fourElements.add(new FourElement(13,"+","1","2","T4",2));
		fourElements.add(new FourElement(14,"*","T4","3","T5",2) );
		fourElements.add(new FourElement(15,"ASSIGN","T5",null,"a",2) );
		fourElements.add(new FourElement(16,"+","i","1","i",2));
		fourElements.add(new FourElement(17,"GOTO",null,null,"(11)",2) );
		fourElements.add(new FourElement(18,"+","i","1","i" ,2));
		fourElements.add(new FourElement(19,"GOTO",null,null,"(6)",2) );
		fourElements.add(new FourElement(20,"JA","a","b","(22)",2));
		fourElements.add(new FourElement(21,"GOTO",null,null,"(27)",2));
		fourElements.add(new FourElement(22,"ASSIGN","0",null,"c",2));
		fourElements.add(new FourElement(23,"JA","a","c","(25)",2)); 
		fourElements.add(new FourElement(24,"GOTO",null,null,"(27)",2));
		fourElements.add(new FourElement(25,"ASSIGN","0",null,"c",2));
		fourElements.add(new FourElement(26,"GOTO",null,null,"(28)",2));
		fourElements.add(new FourElement(27,"ASSIGN","1",null,"c",2));
		fourElements.add(new FourElement(28,"ASSIGN","1",null,"c",2));
		fourElements.add(new FourElement(29,"RETUEN","0",null,null,2));
		
		ObjectCodeGenerater codeGenerater=new MIPSGenerator("/tmp/test",fourElements);
		
		//FileReadUtil.sysoFile(codeGenerater.generator().getName());
		
		//FileReadUtil.sysoFile("a.c");
		List<BaseBlock> baseBlocks=codeGenerater.getBaseBlocks();
		
		for (BaseBlock baseBlock : baseBlocks) {
			System.out.println(baseBlock);
		}
		
		
	}
}
