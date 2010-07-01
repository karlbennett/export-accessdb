date

echo -n "Exporting Data..."
java -jar export-accessdb-1.0.jar /home/karl/Public/V-Basebe-big.mdb 1>smasher.export.log 2>&1
echo " Done."

echo -n "Dropping tables..."
cd output/sql/pre
sh runTableDops.sh $1 $2 1>smasher.drop.tables.log 2>&1
cd ../../..
echo " Done."

echo -n "Creating tables..."
cd output/sql/pre
sh runTableCreates.sh $1 $2 1>smasher.create.tables.log 2>&1
cd ../../..
echo " Done."

echo -n "Importing data..."
cd output
sh runSQLLoader.sh $1 $2 1>smasher.loader.log 2>&1

date