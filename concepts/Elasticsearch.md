# ElasticSearch
- store catalogs
- transaction data
- price alerting - reverse search
- analytics / bi

- ** Near Realtime (NRT) ** - searchable after 1 sec of indexing document
- ** Cluster** : collection of one or more nodes
- ** Node ** : single server
- ** Index ** : collection of documents that have somewhat similar characterstics, eg: customer data, product catalog, order data.
- ** Type ** : with in the index one or more types. Eg Blogging platform - 1 type - user data, 2type - blog data, 3 type - comments
- ** Document ** : basic unit of information.

- Shards & Replicas:
  - Sub divide index into shards

- Each Elasticsearch shard is a Lucene index. There is a maximum number of documents you can have in a single Lucene index. As of LUCENE-5843, the limit is 2,147,483,519 (= Integer.MAX_VALUE - 128) documents. You can monitor shard sizes using the _cat/shards api.

- REST API
  - GET /_cat/indices?v
	  PUT /customer?pretty                - Create Index
	  GET /_cat/indices?v
	  PUT /customer/external/1?pretty     - Create Document
	  GET /customer/external/1?pretty
	  DELETE /customer?pretty             - DELETE Index
	  PUT /customer/external/1?pretty     - Modify document
	  POST /customer/external/1/_update?pretty - Updating Documents
	  DELETE /customer/external/2?pretty       - DELETE Documents
	  POST /customer/external/_bulk?pretty     - BULK Processing

	The Search API
		REST request URI
		REST request body

		GET /bank/_search?q=*&sort=account_number:asc&pretty
	Query DSL

	GET /bank/_search
		{"query": { "match_all": {} }, "_source": ["account_number", "balance"]}         - return only few fields
		{"query": { "match": { "account_number": 20 } }}
		{"query": { "match": { "address": "mill" } }}
		{"query": { "match": { "address": "mill lane" } }}
		{"query": { "match_phrase": { "address": "mill lane" } }}       - Match_Phrase

		{"query": {"bool": {"must": [{ "match": { "address": "mill" } },{ "match": { "address": "lane" } }]}}}    -- bool must - all must be true
		{"query": {"bool": {"should": [{ "match": { "address": "mill" } },{ "match": { "address": "lane" } }]}}}  -- bool should -- or
		{"query": {"bool": {"must_not": [{ "match": { "address": "mill" } },{ "match": { "address": "lane" } }]}}} -- bool must_not


		{"query": {"bool": {"must": [{ "match": { "age": "40" } }],"must_not": [{ "match": { "state": "ID" } }]}}} -- multi level bool logic


	  Filters

		{"query": {"bool": {"must": { "match_all": {} },"filter": {"range": {"balance": {"gte": 20000,"lte": 30000}}}}}}
		{"size": 0,"aggs": {"group_by_state": {"terms": {"field": "state.keyword"}}}}



	Limit Results
		{"from" : 0, "size" : 10, "query" : { "term" : { "user" : "kimchy" } } }
		{"_source": { "includes": [ "obj1.*", "obj2.*" ],"excludes": [ "*.description" ]},"query" : {"term" : { "user" : "kimchy" }}}




	Document apis


	Get apis
	  twitter/tweet/0 (id)
		twitter/tweet/0?_source=false
		twitter/tweet/0?_source_include=*.id&_source_exclude=entities
		twitter/tweet/0?_source=*.id,retweeted
		twitter/tweet/1/_source
		twitter/tweet/1/_source?_source_include=*.id&_source_exclude=entities
HEAD twitter/tweet/1/_source

   Delete api
	   DELETE /twitter/tweet/1
		 twitter/_delete_by_query
		 {"query": { "match": {"message": "some message"}}}

	Multi GET API


	reindex
	  {"source": {"index": "twitter"},"dest": {"index": "new_twitter"}}

	Search API
	  routing ->
		stats group
		global search timeout
		  search.default_search_timeout
		search cancellation
		  search.low_level_cancellation

		/twitter/_search?q=user:kimchy - twitter index and all types
		/twitter/tweet,user/_search?q=user:kimchy - twitter index, only tweet, user types
		/kimchy,elasticsearch/tweet/_search?q=tag:wow -- multiple indices
		/_all/tweet/_search?q=tag:wow -- multiple indices
		/_search?q=tag:wow -- all indices and all types

		URI Search
		twitter/tweet/_search?q=user:kimchy
		Request by body search

		Fast check for any matching docs
		GET /_search?q=message:elasticsearch&size=0&terminate_after=1
		query
		  _search/
			  {
					"query":{
					  "term": {"user": "kimchy"},
						"from" : 0, "size" : 10
					}
				}

				from + size  can not be more than index.max_result_window (default 10000)

SourceFilter ->
      "_source": false,
			"_source": "obj.*",
			"_source": [ "obj1.*", "obj2.*" ],
			"_source": {
        "includes": [ "obj1.*", "obj2.*" ],
        "excludes": [ "*.description" ]
      },


			Search Type
			  query_then_fetch : 2 phases , 1st query forwarded to all shards gets minimal info to merge and fetches only required documents
				dfs_query_then_fetch: distributed term frequencies for more accurate scoring
