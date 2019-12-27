# work with open source project spring-data-example: 
# jdbc
# multi-store

#### Original project: https://github.com/spring-projects/spring-data-examples

### Before you start

```
1) Clone repository on your PC

   git clone https://github.com/EkaterinaEA/spring-data-example

   build project with Maven

   run ApplicationRunner.jar file

```

```
2) Open a Browser and enter the line:

http://localhost:8081/swagger-ui.html#/

```

### List of methods:

#### LegoSet

```

1) POST /legoset save

       - LegoSet creation

2) PUT /legoset update

       - LegoSet editing

3) DELETE /legoset delete

       - LegoSet delete

4) GET /legoset/{all} findById

       - search all LegoSets

5) GET /manual/{id} findById

       - search LegoSet by id

6) DELETE /legoset/{id} deleteById

       - delete LegoSet by id
       
```

#### Manual

```

1) POST /manual save

       - Manual creation

2) PUT /manual update

       - Manual editing

3) DELETE /manual delete

       - Manual delete

4) GET /manual/{all} findById

       - search all Manuals

5) GET /manual/{id} findById

       - search Manual by id

6) DELETE /manual/{id} deleteById

       - delete Manual by id
       
```

#### Model

```

1) POST /model save

       - Model creation

2) PUT /model update

       - Model editing

3) DELETE /model delete

       - Model delete

4) GET /model/{all} findById

       - search all Models

5) GET /model/{id} findById

       - search Model by id

6) DELETE /model/{id} deleteById

       - delete Model by id

```

#### ModelMapEntry

```

1) POST /modelmapentry save

       - ModelMapEntry creation

2) PUT /modelmapentry update

       - ModelMapEntry editing

3) DELETE /modelmapentry delete

       - ModelMapEntry delete

4) GET /modelmapentry/{all} findById

       - search all ModelMapEntry

5) GET /modelmapentry/{id} findById

       - search ModelMapEntry by id

6) DELETE /modelmapentry/{id} deleteById

       - delete ModelMapEntry by id
