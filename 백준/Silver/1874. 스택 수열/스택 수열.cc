#include <iostream>
#include <string>
#include <stack>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	//실행속도도 줄여보자
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int n;
	cin >> n;
	stack<int> st;
	vector<char> ans;
	int f = 1;
	bool com = false;
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		while (f<=a) {
			st.push(f);
			f++;
			ans.push_back('+');
		}
		if (st.top() == a) {
			st.pop();
			ans.push_back('-');
		}
		else {
			com = true;
		}
	}
	if (com) cout << "NO";
	else {
		for (char c : ans)cout << c << "\n";
	}
}
