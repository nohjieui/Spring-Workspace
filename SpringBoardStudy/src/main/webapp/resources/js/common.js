/* path경로 : /myapp */
export const path = getContextPath();

function getContextPath(){
    let hostIndex = location.href.indexOf(location.host) + location.host.length;
    /*
        location.href -> 'http://localhost:8081/myapp/member/insert'
        location.host -> localhost:8081
        location.href.indexOf(location.host) -> 7
        location.host.length -> 14
    */
    let path = location.href.substring(hostIndex,location.href.indexOf("/", hostIndex+1));

    return path;
}