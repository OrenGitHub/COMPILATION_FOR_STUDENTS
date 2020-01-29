method FindMax(a:array<int>) returns (max_index:int)
	requires a.Length > 0
	ensures 0 <= max_index < a.Length
	ensures forall k :: 0 <= k < a.Length ==> a[k] <= a[max_index]
{
	var index := 0;
	max_index := 0;
	while index < a.Length
		invariant 0 <= max_index < a.Length
		invariant 0 <= index <= a.Length
		invariant forall k :: 0 <= k < index ==> a[k] <= a[max_index]
	{
		if (a[max_index] < a[index]) {
			  max_index :=   index;
		}
		index := index + 1;
	}
	return max_index;
}

method Main()
{
	var i := 0;
	var a := new int[7];
	a[0],a[1],a[2],a[3],a[4],a[5],a[6] :=
	4,2,0,9,15,8,3;
	print "a = {";
	while (i < 6) { print a[i], ","; i := i+1; }
	print a[6], "}\n";
	var max_index := FindMax(a);
	print "max = ", a[max_index], "\n";
}
