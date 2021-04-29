package classcreation;

import interfaceCreation.Question6chap9;

public class chap9BaseCla {
    protected class Ex6BaseInner implements Question6chap9 {
	// need public constructor to create one in chap9BaseCla child:
	public Ex6BaseInner() { }
	public String say() { return "Hi"; }
	}
 }
