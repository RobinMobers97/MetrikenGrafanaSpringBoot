/*
Hier kann die Kommunikation zum json-server modifiziert werden.

Bei POST, DELETE, PUT und PATCH Endpunkten verlangt der Server eine 'id' in den Objekten
welche mitgegeben werden, um diese in der 'mock-data.json' zu ändern. Um das zu umgehen
wird hier die Response mit den erwarteten Werten abgefangen und abgeändert.
*/

module.exports = function (req, res, next) {

};
