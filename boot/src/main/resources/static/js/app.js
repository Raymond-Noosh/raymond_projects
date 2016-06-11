function lnkSelectStore_click(e) {
    window.open('https://storelocator.staples.com/?locale=en_US_cp&returnurl=https://staplespunchout.nowdocs.com/P2S/SelectedStore.htm', 'winStoreLocator', 'width=1020,height=725,frameBorder=0,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no');
}

function click5(e) {
    window.open('http://localhost:8080/popup', 'winStoreLocator', 'width=1020,height=725,frameBorder=0,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no');
    //window.open('https://storelocator.staples.com/?locale=en_US_cp&returnurl=https://staplespunchout.nowdocs.com/P2S/SelectedStore.htm', 'Popup', 'width=400,height=200,scrollbars=yes');
}

function click4(e) {
    console.info(e);
    window.open('https://storelocator.staples.com/?locale=en_US_cp&returnurl=http://localhost:8080'+e, 'winStoreLocator', 'width=1020,height=725,frameBorder=0,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no');
}

function updateStore(storeId) {
    console.info(storeId);
}