/***********/
/* PACKAGE */
/***********/
package LLVM;

/*******************/
/* GENERAL IMPORTS */
/*******************/
import java.io.*;
import java.io.PrintWriter;

/*******************/
/* PROJECT IMPORTS */
/*******************/
import TEMP.*;

/********/
/* LLVM */
/********/
public class LLVM
{
	private int WORD_SIZE=4;

	/***********************/
	/* The file writer ... */
	/***********************/
	private PrintWriter fileWriter;

	/***********************/
	/* The file writer ... */
	/***********************/
	public void finalizeFile()
	{
		fileWriter.close();
	}
	public void print_int(TEMP t)
	{
		int idx=t.getSerialNumber();
		fileWriter.format("shalom\n");
		// fileWriter.format("  call void PrintInt(i32 %% %Temp_444)\n");
	}

	public void allocate(String var_name)
	{
		fileWriter.format(";;;;;;;;;;;;;;;;;;;\n");
		fileWriter.format(";                 ;\n");
		fileWriter.format("; GLOBAL VARIABLE ;\n");
		fileWriter.format(";                 ;\n");
		fileWriter.format(";;;;;;;;;;;;;;;;;;;\n");
		fileWriter.format("@%s = global i32 0, align 4\n\n",var_name);
	}
	public void load(TEMP dst,String var_name)
	{
		int idxdst=dst.getSerialNumber();
		fileWriter.format("  %%Temp_%d = load i32, i32* @%s, align 4\n",idxdst,var_name);
	}
	public void store(String var_name,TEMP src)
	{
		int idxsrc=src.getSerialNumber();
		fileWriter.format("  store i32 Temp_%d, i32* @%s, align 4\n",idxsrc,var_name);		
	}
	public void li(TEMP t,int value)
	{
		int idx=t.getSerialNumber();
		fileWriter.format("  li Temp_%d,%d\n",idx,value);
	}
	public void add(TEMP dst,TEMP oprnd1,TEMP oprnd2)
	{
		int i1 =oprnd1.getSerialNumber();
		int i2 =oprnd2.getSerialNumber();
		int dstidx=dst.getSerialNumber();

		fileWriter.format(
			"  %%Temp_%d = add nsw i32 %%Temp_%d, %%Temp_%d\n",
			dstidx,
			i1,
			i2);
	}
	public void mul(TEMP dst,TEMP oprnd1,TEMP oprnd2)
	{
		int i1 =oprnd1.getSerialNumber();
		int i2 =oprnd2.getSerialNumber();
		int dstidx=dst.getSerialNumber();

		fileWriter.format(
			"  %%Temp_%d = mul nsw i32 %%Temp_%d, %%Temp_%d\n",
			dstidx,
			i1,
			i2);
	}
	public void icmp_lt(TEMP dst,TEMP oprnd1,TEMP oprnd2)
	{
		int i1 =oprnd1.getSerialNumber();
		int i2 =oprnd2.getSerialNumber();
		int dstidx=dst.getSerialNumber();

		fileWriter.format(
			"  %%Temp_%d = icmp slt i32 %%Temp_%d, %%Temp_%d\n",
			dstidx,
			i1,
			i2);
	}
	public void icmp_eq(TEMP dst,TEMP oprnd1,TEMP oprnd2)
	{
		int i1 =oprnd1.getSerialNumber();
		int i2 =oprnd2.getSerialNumber();
		int dstidx=dst.getSerialNumber();

		fileWriter.format(
			"  %%Temp_%d = icmp eq i32 %%Temp_%d, %%Temp_%d\n",
			dstidx,
			i1,
			i2);
	}
	public void label(String inlabel)
	{
		if (inlabel.equals("main"))
		{
			fileWriter.format(";;;;;;;;;;;;;;;;;;;;;;;\n");
			fileWriter.format(";                     ;\n");
			fileWriter.format("; ENTRY POINT :: main ;\n");
			fileWriter.format(";                     ;\n");
			fileWriter.format(";;;;;;;;;;;;;;;;;;;;;;;\n");
			fileWriter.format("define dso_local i32 @main(i32 %%argc, i8** %%argv) {\nentry:\n");
		}
		else
		{
			fileWriter.format("\n%s:\n\n",inlabel);
		}
	}	
	public void jump(String inlabel)
	{
		fileWriter.format("  br label %% %s\n",inlabel);
	}	
	public void blt(TEMP oprnd1,TEMP oprnd2,String label)
	{
		int i1 =oprnd1.getSerialNumber();
		int i2 =oprnd2.getSerialNumber();
		
		fileWriter.format("  %%oren = icmp eq i32 Temp_%d, 0\n",i1);
		fileWriter.format("  br i1 %%oren, label %% %s, label %%any.label\n",label);
		fileWriter.format("  \nany.label:\n\n");
	}
	public void bge(TEMP oprnd1,TEMP oprnd2,String label)
	{
		int i1 =oprnd1.getSerialNumber();
		int i2 =oprnd2.getSerialNumber();
		
		fileWriter.format("  %%oren = icmp eq i32 Temp_%d, 0\n",i1);
		fileWriter.format("  br i1 %%oren, label %% %s, label %%any.label\n",label);
		fileWriter.format("  \nany.label:\n\n");
	}
	public void bne(TEMP oprnd1,TEMP oprnd2,String label)
	{
		int i1 =oprnd1.getSerialNumber();
		int i2 =oprnd2.getSerialNumber();
		
		fileWriter.format("  %%oren = icmp eq i32 Temp_%d, 0\n",i1);
		fileWriter.format("  br i1 %%oren, label %% %s, label %%any.label\n",label);
		fileWriter.format("  \nany.label:\n\n");
	}
	public void beq(TEMP oprnd1,TEMP oprnd2,String label)
	{
		int i1 =oprnd1.getSerialNumber();
		int i2 =oprnd2.getSerialNumber();
		
		fileWriter.format("  %%oren = icmp eq i32 Temp_%d, 0\n",i1);
		fileWriter.format("  br i1 %%oren, label %% %s, label %%any.label\n",label);
		fileWriter.format("  \nany.label:\n\n");
	}
	public void beqz(TEMP oprnd1,String label)
	{
		int i1 =oprnd1.getSerialNumber();

		fileWriter.format("  %%oren = icmp eq i32 Temp_%d, 0\n",i1);
		fileWriter.format("  br i1 %%oren, label %% %s, label %%any.label\n",label);
		fileWriter.format("  \nany.label:\n\n");
	}
	
	/**************************************/
	/* USUAL SINGLETON IMPLEMENTATION ... */
	/**************************************/
	private static LLVM instance = null;

	/*****************************/
	/* PREVENT INSTANTIATION ... */
	/*****************************/
	private LLVM() {}

	/******************************/
	/* GET SINGLETON INSTANCE ... */
	/******************************/
	public static LLVM getInstance()
	{
		if (instance == null)
		{
			instance = new LLVM();
			
			/****************************/
			/* Initialize a file writer */
			/****************************/
			try
			{
				String dirname="./FOLDER_5_OUTPUT/";
				String filename="LLVM_bitcode.ll";
				assert(false);
				instance.fileWriter = new PrintWriter(dirname+filename);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

			/***********************************/
			/* Print LLVM 6.0.0 bitcode header */
			/***********************************/
			instance.fileWriter.print("LLVM\n");
			instance.fileWriter.print("{\n");
		}
		return instance;
	}
}
