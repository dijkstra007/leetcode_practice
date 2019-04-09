//https://leetcode.com/problems/encode-and-decode-tinyurl/
class Solution {
public:
    map<int, pair<string,string> > db;
    map<string, string> db_2;
    int incrementer = 100;
    char backup_ch;
    // Encodes a URL to a shortened URL.
    string encode(string longUrl) {
        char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int n = incrementer;
        int id = incrementer;
        incrementer ++;
        string shortUrl = "";
        while(n) {
            shortUrl.push_back( map[n%62] );
            n = n / 62;
        }
        reverse(shortUrl.begin(), shortUrl.end());
        db[id] = make_pair(longUrl, shortUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    string decode(string shortUrl) {
        int id = 0;
        int n = shortUrl.length();
        string s = shortUrl;
        for(int i = 0 ; i < n ; i++) {
            int k = n - i - 1;
            if('a' <= s[i] && s[i] <= 'z') {
                id += (s[i] - 'a') * (int)pow(62, k);
            }
            else if('A' <= s[i] && s[i] <= 'Z') {
                id+= (s[i] - 'A' + 26) * (int)pow(62, k);
            } else if('0' <= s[i] && s[i] <= '9') {
                id+= (s[i] - '0' + 52) * (int)pow(62, k);
            }
        }
        return db[id].first;
    }
};

// Your Solution object will be instantiated and called as such:
// Solution solution;
// solution.decode(solution.encode(url));
