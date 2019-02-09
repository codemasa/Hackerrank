#include <bits/stdc++.h>

using namespace std;

// Complete the isValid function below.
string isValid(string s) {

    map<char, int> letters;
    map<int, int> letterCount;
    int max = 0;
    int min = 100000;
    int uniques = 0;
    for(int i = 0 ; i < s.size() ; i++) {
        if(letters[s.at(i)]){
            letters[s.at(i)]++;
        }else{
            letters[s.at(i)] = 1;
            uniques++;
        }
    }
    for(map<char,int>::iterator it=letters.begin() ; it!=letters.end() ; ++it){
        if(letterCount[it->second]) {
            letterCount[it->second]++;
        }else {
            letterCount[it->second] = 1;
        }
    }
    for(map<int,int>::iterator it=letterCount.begin() ; it!=letterCount.end() ; ++it){
        if(it->second > max) {
            max = it->second;
        }
        if(it->second < min) {
            min = it->second;
        }
    }

    map<int,int>::iterator begin = letterCount.begin();
    map<int,int>::iterator end = letterCount.end();
    --end;

    int maxMultiples = end->first;
    int amountMax = end->second;
    int minMultiples = begin->first;
    int amountMin = begin->second;

    cerr << "max: " << max << endl << "min: " << min << endl << "maxMultiples: " << maxMultiples << endl << "minMultiples: " << minMultiples << endl << "amountMax: " << amountMax << endl << "amountMin: " << amountMin << endl << "uniques: " << uniques << endl;
    if(amountMax == uniques || amountMin == uniques) {
        return "YES";
    }
    else if(letterCount.size() > 2) {
        return "NO";
    }
    else if((minMultiples == 1 && amountMin == 1) || (maxMultiples-minMultiples == 1 && amountMax == 1)){
        return "YES";
    }

    return "NO";
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    string result = isValid(s);

    fout << result << "\n";

    fout.close();

    return 0;
}
