/**
 *
 * Created by Yuan on 2015/7/14 0014.
 */
function dateformat(birthDate) {
    var date = new Date(birthDate);
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    var d = date.getDate();
    return y + '-' + (m > 9 ? m : '0' + m) + '-' + (d > 9 ? d : '0' + d);
};
